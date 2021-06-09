package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

import java.util.HashMap;

public class SpriteHelper {

    public static Texture badlogic = null;
    public static Texture proceduralTexture = null;

    public static Sprite createProceduralSprite(){

        if (proceduralTexture == null)
        {
            Pixmap pm = new Pixmap(20,20, Pixmap.Format.RGBA8888);

            pm.setColor(1f,1f,1f, 0.9f);

            pm.fillRectangle(0,0,20,20);

            pm.setColor(0f,0f,0f,1f);

            pm.drawRectangle(0,0,20,20);

            proceduralTexture = new Texture(pm);
            //Texture t = new Texture(pm);
        }


        Sprite s = new Sprite(proceduralTexture);

        float randomNum = MathUtils.random(0.75f,1.5f);

        s.setSize(randomNum,randomNum);

        s.setPosition(MathUtils.random(-2f,2f),MathUtils.random(-2f,2f));

        s.setOriginCenter();

        s.setColor(MathUtils.random(0f,1f),MathUtils.random(0f,1f),MathUtils.random(0f,1f),1f);

        return s;

    }

}
