package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Look_LVL {
    int numberKey = 5;
    int numberEnemy =6;
    int ourNumber;
    Texture panelInformation;
    public boolean detectKey;
    public boolean detectEnemy;
    public boolean detectNothing;
    public boolean detectSomething;
    ButtonClosePanelLook buttonClose;
    ButtonFightEnemy buttonFight;
    BitmapFont title;


    public Look_LVL()
    {
        panelInformation = AssetManager.getInstance().panelLookLvl;
        buttonClose = new ButtonClosePanelLook(-3,-1.5f,2,1);
        buttonFight = new ButtonFightEnemy(1,-1.5f,2,1);
        title = AssetManager.getInstance().titlePanelLookLvl;
        title.getData().setScale(0.1f,0.1f/2);
    }

    public void render(SpriteBatch batch)
    {
        if(detectKey )
        {
            batch.draw(panelInformation,-3.5f,-2,7,5);
            title.draw(batch,"Key: ",-3.5f,2f);
            buttonClose.render(batch);
        }
        else if(detectNothing)
        {
            batch.draw(panelInformation,-3.5f,-2,7,5);
            title.draw(batch,"Nothing: ",-3.5f,2f);
            buttonClose.render(batch);
        }
        else if(detectEnemy)
        {
            batch.draw(panelInformation,-3.5f,-2,7,5);
            title.draw(batch,"Enemiy: ",-3.5f,2f);
            buttonClose.render(batch);
            buttonFight.render(batch);
        }

    }

    public void CalculateThingToFind()
    {

        ourNumber = (int)(Math.random()*numberEnemy+1);
        System.out.println(ourNumber);

        if(ourNumber == numberEnemy)
        {
            System.out.println("enemigo");
            detectEnemy=true;
            detectSomething=true;
        }
        else if(ourNumber==numberKey)
        {
            detectKey=true;
            detectSomething=true;
            Iventory.getInstance().haveKey=true;
            System.out.println("llave");
        }
        else if(ourNumber!=numberEnemy && ourNumber!=numberKey)
        {
            detectNothing=true;
            detectSomething=true;
            System.out.println("nada");
        }

    }

    public void ClosePanelLook()
    {
        detectEnemy=false;
        detectKey=false;
        detectNothing=false;
        detectSomething=false;
    }

}
