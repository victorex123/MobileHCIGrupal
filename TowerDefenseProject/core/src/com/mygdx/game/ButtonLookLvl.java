package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ButtonLookLvl extends Button{
    public ButtonLookLvl(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.texture = AssetManager.getInstance().lookLvlButton;
        this.bounds = new Rectangle(this.x,this.y,this.width,this.height);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
    }

    @Override
    public boolean CheckBounds(float x, float y) {
        return this.bounds.contains(x, y);
    }
}
