package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UpLevel {
    BitmapFont textLVL;
    public UpLevel()
    {
        textLVL = AssetManager.getInstance().textActualLvl;
        textLVL.getData().setScale(0.1f);
    }

    public void render(SpriteBatch batch)
    {
        textLVL.draw(batch,""+Iventory.getInstance().actualLVL,-4f,4f);
    }

    public void ClimbLvl()
    {
        Iventory.getInstance().actualLVL+=1;
        Iventory.getInstance().haveKey=false;
    }

}
