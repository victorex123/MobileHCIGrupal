package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ButtonMusic extends Button {
    public boolean musicON=true;
    public Texture textureMusicON = AssetManager.getInstance().buttonMusicON;
    public Texture textureMusicOFF = AssetManager.getInstance().buttonMusicOFF;
    public ButtonMusic(float x, float y, float width, float height) {
        super(x, y, width, height);

        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);

    }

    @Override
    public void render(SpriteBatch batch) {
        if(musicON)
        {
            batch.draw(textureMusicON, this.x, this.y, this.width, this.height);
        }
        else
        {
            batch.draw(textureMusicOFF, this.x, this.y, this.width, this.height);
        }


    }

    @Override
    public boolean CheckBounds(float x, float y) {
        return this.bounds.contains(x, y);
    }
}
