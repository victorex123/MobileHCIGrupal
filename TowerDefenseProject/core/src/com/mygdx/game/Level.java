package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.rmi.dgc.DGC;
import java.util.ArrayList;
import java.util.Vector;

public class Level
{

    OrthographicCamera camera;
    CameraHelper cameraHelper;
    ButtonExitGame exitButton;
    ButtonLookLvl lookLvlButton;
    ButtonUpLvl upLvlButton;
    ButtonMusic musicButton;
    ArrayList<Button> buttonArrayList;
    Look_LVL actionLookLvl;
    UpLevel upLevel;
    public boolean changelvl=false;
    public boolean winTheGame=false;
    /*
    ArrayList<GameObject> gos;
    ArrayList<GameObject> inactiveGos;
    Wave wave;
    float timer;
    int enemyIterator;
    int groupIterator;

    int playerHP;
    int money;*/

    Level()
    {
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);
        camera.update();

        cameraHelper = new CameraHelper(camera);

        exitButton = new ButtonExitGame(5,2.5f,2,1);
        lookLvlButton = new ButtonLookLvl(3,-4,2,1);
        upLvlButton = new ButtonUpLvl(-5,-4,2,1);
        musicButton = new ButtonMusic(-6,2.5f,1.5f,1.5f);
        actionLookLvl = new Look_LVL();
        upLevel = new UpLevel();

        buttonArrayList = new ArrayList<>();
        buttonArrayList.add(exitButton);
        buttonArrayList.add(lookLvlButton);
        buttonArrayList.add(upLvlButton);
        buttonArrayList.add(musicButton);
        buttonArrayList.add(actionLookLvl.buttonClose);
        buttonArrayList.add(actionLookLvl.buttonFight);

    }

    public void update(float delta)
    {

    }

    public void render(SpriteBatch batch)
    {
        exitButton.render(batch);
        lookLvlButton.render(batch);
        upLvlButton.render(batch);
        musicButton.render(batch);
        actionLookLvl.render(batch);
        upLevel.render(batch);

    }

    public float calculateDistanceBetweenGameObjects(GameObject gameObject1, GameObject gameObject2)
    {
        return (float) Math.sqrt(Math.pow((gameObject2.position.x-gameObject1.position.x),2)+
                Math.pow((gameObject2.position.y-gameObject1.position.y),2));
    }
}
