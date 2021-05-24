package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;

public class TurretBullet extends GameObject
{

    float rotation;
    int bulletType;
    float speed;
    float timer;
    float dieTime;
    boolean deadBullet;
    Vector2 vectorDirection;

    ArrayList<GameObject> targets;
    GameObject currentTarget;
    boolean attacking;

    public TurretBullet(float x, float y, float width, float height, String tag, int type, float dirX, float dirY)
    {
        super(x,y,width,height,tag);
        this.bulletType = type;
        this.vectorDirection = new Vector2();
        this.vectorDirection.x = dirX-x;
        this.vectorDirection.y = dirY-y;
        this.vectorDirection.nor();
        this.speed = 6f;
        this.dieTime = 5;
        this.timer = dieTime;
        this.deadBullet = false;

        double degrees = Math.atan2(dirY - position.y,dirX - position.x) * 180.0d / Math.PI;
        this.rotation = ((float) degrees)+270;

    }

    @Override
    public void update(float delta)
    {
        timer -= delta;
        if (timer <= 0)
        {
            deadBullet = true;
        }
        move(delta);
    }

    public boolean isDead()
    {
        return deadBullet;
    }

    public void destroyBullet()
    {
        deadBullet = true;
    }

    public int getBulletType()
    {
        return bulletType;
    }

    private void move (float delta)
    {
        Vector2 step = vectorDirection.cpy().scl(delta*this.speed);

        this.position.add(step);
    }

    @Override
    public void render(SpriteBatch batch)
    {
        if (bulletType == 0)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.GUNAMMO),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation);
        }
        if (bulletType == 1)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.LASERAMMO),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation);
        }
    }

    @Override
    public void lookAt(Vector2 targetPosition) {

    }
}
