package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameBackground extends GameObject{


    public GameBackground(float x, float y, float width, float height)
    {
        super(x,y,width,height,"Background");
    }


    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.BACKGROUND),
                this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void lookAt(Vector2 targetPosition) {

    }
}
