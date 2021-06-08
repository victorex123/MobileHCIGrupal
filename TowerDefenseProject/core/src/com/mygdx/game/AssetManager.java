package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.w3c.dom.Text;

public class AssetManager
{
    public enum TEXTURES {BACKGROUND, UFO, BASE, SHIELD, GUN, GUNAMMO, LASERTURRET, LASERAMMO};

    private TextureAtlas atlas = null;

    private TextureRegion background = null;
    private TextureRegion ufo = null;
    private TextureRegion base = null;
    private TextureRegion shield = null;
    private TextureRegion gun = null;
    private TextureRegion gunammo = null;
    private TextureRegion laserturret = null;
    private TextureRegion laserammo = null;

    public Texture titleGame;
    public Texture startGame;
    public Texture exitButton;
    public Texture lookLvlButton;
    public Texture lvlUpButton;
    public Texture buttonMusicON;
    public Texture buttonMusicOFF;

    private static AssetManager instance = null;

    private AssetManager()
    {

        atlas = new TextureAtlas(Gdx.files.internal("spriteSheet.atlas"));
        background = atlas.findRegion("SpaceBackground");
        ufo = atlas.findRegion("ufo");
        base = atlas.findRegion("torreBase");
        shield = atlas.findRegion("shield");
        gun = atlas.findRegion("torreMetralleta");
        gunammo = atlas.findRegion("bullet");
        laserturret = atlas.findRegion("torreRayo");
        laserammo = atlas.findRegion("torreRayoAmmo");

        titleGame = new Texture(Gdx.files.internal("TittleGame.png"));
        startGame = new Texture(Gdx.files.internal("PressToStart.png"));
        exitButton = new Texture(Gdx.files.internal("ButtonExit.jpg"));
        lookLvlButton = new Texture(Gdx.files.internal("ButtonLookLvl.jpg"));
        lvlUpButton = new Texture(Gdx.files.internal("ButtonUpLvl.jpg"));
        buttonMusicON = new Texture(Gdx.files.internal("buttonMusicON.PNG"));
        buttonMusicOFF = new Texture(Gdx.files.internal("buttonMusicOFF.PNG"));


    }

    public static AssetManager getInstance()
    {
        if (instance == null)
        {
            instance = new AssetManager();
        }
        return instance;
    }

    public TextureRegion getTRByEnum(TEXTURES id)
    {
        if (id == TEXTURES.BACKGROUND) return background;
        if (id == TEXTURES.UFO) return ufo;
        if (id == TEXTURES.BASE) return base;
        if (id == TEXTURES.SHIELD) return shield;
        if (id == TEXTURES.GUN) return gun;
        if (id == TEXTURES.GUNAMMO) return gunammo;
        if (id == TEXTURES.LASERTURRET) return laserturret;
        if (id == TEXTURES.LASERAMMO) return laserammo;
        return null;
    }
}
