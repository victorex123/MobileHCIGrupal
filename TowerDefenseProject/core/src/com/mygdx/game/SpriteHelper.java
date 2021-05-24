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

    public static Sprite getSpriteFromAtlasA()
    {

        TextureRegion tr = AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.UFO);

        Sprite s = new Sprite(tr);
        s.setSize(2.5f,4);
        s.setOriginCenter();
        s.setPosition(MathUtils.random(-2.5f,2.5f),MathUtils.random(-2.5f,2.5f));
        return s;
    }

    public static Sprite getSpriteFromAtlasB()
    {
        TextureRegion tr = AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.UFO);

        Sprite s = new Sprite(tr);
        s.setSize(2.5f,4);
        s.setOriginCenter();
        s.setPosition(MathUtils.random(-2.5f,2.5f),MathUtils.random(-2.5f,2.5f));
        return s;
    }

    public static Sprite spriteFromInventedTextureRegionA(){
        if (badlogic == null){
            badlogic = new Texture(Gdx.files.internal("spriteSheet.png"));
        }

        TextureRegion tr = new TextureRegion(badlogic,0,0,25,40);

        Sprite s = new Sprite(tr);
        s.setSize(1,2);
        s.setOriginCenter();
        s.setPosition(MathUtils.random(-2.5f,2.5f),MathUtils.random(-2.5f,2.5f));
        return s;
    }

    public static Sprite spriteFromInventedTextureRegionB(){
        if (badlogic == null){
            badlogic = new Texture(Gdx.files.internal("spriteSheet.png"));
        }

        TextureRegion tr = new TextureRegion(badlogic,826,0,25,40);

        Sprite s = new Sprite(tr);
        s.setSize(1,2);
        s.setOriginCenter();
        s.setPosition(MathUtils.random(-2.5f,2.5f),MathUtils.random(-2.5f,2.5f));
        return s;
    }


    public static Sprite giveMeASpriteNow(){

        if (badlogic == null){
            badlogic = new Texture(Gdx.files.internal("badlogic.jpg"));
        }

        Sprite s = new Sprite(badlogic);
        s.setSize(1,1);
        s.setOriginCenter();
        s.setPosition(MathUtils.random(-2.5f,2.5f),MathUtils.random(-2.5f,2.5f));
        return s;
    }

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
