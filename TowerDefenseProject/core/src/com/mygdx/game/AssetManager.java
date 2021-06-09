package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.w3c.dom.Text;

public class AssetManager
{
    public Texture titleGame;
    public Texture startGame;
    public Texture exitButton;
    public Texture lookLvlButton;
    public Texture lvlUpButton;
    public Texture buttonMusicON;
    public Texture buttonMusicOFF;
    public Texture panelLookLvl;
    public Texture buttonClosePanel;
    public Texture buttonFightEnemy;
    public Texture lvlUp2Button;
    public BitmapFont titlePanelLookLvl;
    public BitmapFont textActualLvl;
    public Texture youWin;
    public Texture backMenu;

    public Texture button;

    public BitmapFont font;


    private static AssetManager instance = null;

    private AssetManager()
    {
        font = new BitmapFont();

        titleGame = new Texture(Gdx.files.internal("TittleGame.png"));
        startGame = new Texture(Gdx.files.internal("PressToStart.png"));
        exitButton = new Texture(Gdx.files.internal("ButtonExit.jpg"));
        lookLvlButton = new Texture(Gdx.files.internal("ButtonLookLvl.jpg"));
        lvlUpButton = new Texture(Gdx.files.internal("ButtonUpLvl.jpg"));
        lvlUp2Button = new Texture(Gdx.files.internal("ButtonUpLvl2.jpg"));
        buttonMusicON = new Texture(Gdx.files.internal("buttonMusicON.PNG"));
        buttonMusicOFF = new Texture(Gdx.files.internal("buttonMusicOFF.PNG"));
        panelLookLvl = new Texture(Gdx.files.internal("Menulvl.PNG"));
        buttonClosePanel = new Texture(Gdx.files.internal("ButtonClosePanel.jpg"));
        buttonFightEnemy = new Texture(Gdx.files.internal("ButtonFightEnemy.jpg"));
        titlePanelLookLvl = new BitmapFont();
        textActualLvl = new BitmapFont();
        youWin = new Texture(Gdx.files.internal("YouWin.png"));
        backMenu =new Texture(Gdx.files.internal("BackMenu.png"));
        button = createButtonTexture();
    }

    private Texture createButtonTexture() {
        Pixmap pm = new Pixmap(10,10, Pixmap.Format.RGBA8888);
        pm.setColor(0.1f,0.1f,0.1f,1);
        pm.drawRectangle(0,0,10,10);
        pm.setColor(0.1f,0.1f,0.1f,1);
        pm.fillRectangle(1,1,8,8);
        return new Texture(pm);
    }



    public static AssetManager getInstance()
    {
        if (instance == null)
        {
            instance = new AssetManager();
        }
        return instance;
    }


}
