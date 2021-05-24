package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract  class GameObject
{
    private float x;
    private float y;
    private String tag;

    //
    protected Vector2 position;
    protected Vector2 dimension;

    public  float getX() { return this.x; }
    public  float getY() { return this.y; }
    public  Vector2 getDimension() { return this.dimension; }
    public  Vector2 getPosition() { return this.position; }
    public float getWidth() { return  this.dimension.x; }
    public void setWidth(float width) { this.dimension.x = width; }
    public float getHeight() { return  this.dimension.y; }
    public void setHeight(float height) { this.dimension.y = height; }
    public String getTag() { return  this.tag; }
    public void setTag(String tag) { this.tag = tag; }

    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);
    public abstract void lookAt(Vector2 targetPosition);

    GameObject()
    {
        this(0f,0f,1f,1f,"tag");
    }

    public GameObject(float x, float y, float width, float height, String tag)
    {
        this.x = x;
        this.y = y;
        dimension = new Vector2(width,height);
        position = new Vector2(x,y);
        this.tag = tag;

        //This is always call
    }

    public void translate(float x, float y)
    {
        this.x += x;
        this.y += y;
        position.add(x,y);
    }

    public boolean checkCollisionWithRadius(float x, float y)
    {
        float radius = getHeight();
        if (this.getPosition().x < x && x < this.getPosition().x+radius && this.getPosition().y < y && y < this.getPosition().y+radius)
        {
            return true;
        }
        return false;
    }

    public boolean checkCollisionBullets(float x, float y)
    {
        float radius = this.getHeight();
        if (calculateDistanceBetweenPoints(x,y) < radius)
        {
            return true;
        }
        return false;
    }

    public boolean checkCollisionWithRadiusBuild(float x, float y)
    {
        float radius = this.getHeight()+Constants.BUILD_TRESHOLD;
        if (this.getPosition().x-radius < x && x < this.getPosition().x+radius && this.getPosition().y-radius < y && y < this.getPosition().y+radius)
        {
            return true;
        }
        return false;
    }

    public float calculateDistanceBetweenPoints(float otherX, float otherY)
    {
        return (float) Math.sqrt(Math.pow((otherX-(this.position.x+this.dimension.x/2)),2)+
                Math.pow((otherY-(this.position.y+this.dimension.y/2)),2));
    }
}
