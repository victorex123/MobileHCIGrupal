package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ButtonUpLvl extends Button{
    public ButtonUpLvl(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.texture = AssetManager.getInstance().lvlUpButton;
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
