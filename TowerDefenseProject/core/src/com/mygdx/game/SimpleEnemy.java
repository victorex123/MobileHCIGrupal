package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SimpleEnemy extends GameObject
{
    public SimpleEnemy(float x, float y, float width, float height, String tag)
    {
        super(x,y,width,height,tag);
    }

    @Override
    public void lookAt(Vector2 targetPosition) {

    }

    @Override
    public void update(float delta)
    {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.UFO),
                this.getX(), this.getY(), this.getWidth(), this.getHeight());

    }
}
