package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.rmi.dgc.DGC;
import java.util.ArrayList;
import java.util.Vector;

public class Level
{
    MonsterManager monstersSpawner;

    OrthographicCamera camera;
    OrthographicCamera hudCamera;
    CameraHelper cameraHelper;
    ButtonExitGame exitButton;
    ButtonLookLvl lookLvlButton;
    ButtonUpLvl upLvlButton;
    ButtonMusic musicButton;
    ArrayList<Button> buttonArrayList;
    Look_LVL actionLookLvl;
    UpLevel upLevel;
    FightPanel fightPanel;
    ButtonClosePanelLook closeFightPanelButton;
    public boolean changelvl=false;
    public boolean winTheGame=false;

    Deck playerDeck;

    Level()
    {
        playerDeck = new Deck();
        monstersSpawner = new MonsterManager();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.position.set(0,0,0);
        camera.update();

        cameraHelper = new CameraHelper(camera);

        exitButton = new ButtonExitGame(5,2.5f,2,1);
        lookLvlButton = new ButtonLookLvl(3,-4,2,1);
        upLvlButton = new ButtonUpLvl(-5,-4,2,1);
        musicButton = new ButtonMusic(-6,2.5f,1.5f,1.5f);
        actionLookLvl = new Look_LVL();
        closeFightPanelButton = new ButtonClosePanelLook(0,0,200,200);
        fightPanel = new FightPanel("Te has encontrado con un fiero enemigo.",0-800/2,
                0-275/2,800,275,closeFightPanelButton);
        closeFightPanelButton = new ButtonClosePanelLook(-5,-2,2,1f);
        upLevel = new UpLevel();

        buttonArrayList = new ArrayList<>();
        buttonArrayList.add(exitButton);
        buttonArrayList.add(lookLvlButton);
        buttonArrayList.add(upLvlButton);
        buttonArrayList.add(musicButton);
        buttonArrayList.add(actionLookLvl.buttonClose);
        buttonArrayList.add(actionLookLvl.buttonFight);
        buttonArrayList.add(fightPanel.buttonClose);
        buttonArrayList.add(closeFightPanelButton);

        playerDeck.initDeck();

        playerDeck.addCard(monstersSpawner.getKing());
        playerDeck.addCard(monstersSpawner.getQueen());
        playerDeck.addCard(monstersSpawner.getKnight());
        playerDeck.addCard(monstersSpawner.getArcher());
        playerDeck.addCard(monstersSpawner.getAngryFarmer());
        playerDeck.addCard(monstersSpawner.getOrcLeader());
        playerDeck.addCard(monstersSpawner.getThugGoblin());
        playerDeck.addCard(monstersSpawner.getOrcLeader());

    }

    public void update(float delta)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Y))
        {
            Gdx.app.debug("DECK","The player has:");
            for (int i = 0; i < playerDeck.cards.size(); i++)
            {
                Gdx.app.debug("DECK",playerDeck.cards.get(i).name);
            }
        }
    }

    public void render(SpriteBatch batch)
    {
        exitButton.render(batch);
        lookLvlButton.render(batch);
        upLvlButton.render(batch);
        musicButton.render(batch);
        actionLookLvl.render(batch);
        upLevel.render(batch);
        if(fightPanel.fighting) closeFightPanelButton.render(batch);
    }

    public void renderHud(SpriteBatch batch)
    {
        fightPanel.render(batch);
    }

    public float calculateDistanceBetweenGameObjects(GameObject gameObject1, GameObject gameObject2)
    {
        return (float) Math.sqrt(Math.pow((gameObject2.position.x-gameObject1.position.x),2)+
                Math.pow((gameObject2.position.y-gameObject1.position.y),2));
    }
}
