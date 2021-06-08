package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Button {

    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected Rectangle bounds;
    protected Texture texture;

    public Button(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height =height;


    }

    public void render(SpriteBatch batch) {

        batch.draw(texture,this.x,this.y,this.width,this.height);

    }

    public boolean CheckBounds(float x, float y){
        return bounds.contains(x,y);
    }
}

