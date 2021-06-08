package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ButtonExitGame extends Button{
    public ButtonExitGame(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.texture = AssetManager.getInstance().exitButton;
        this.bounds = new Rectangle(this.x,this.y,this.width,this.height);
        System.out.println("B x:"+this.x+"- B y:"+this.y);
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
