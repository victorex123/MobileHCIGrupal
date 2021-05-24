package com.mygdx.game;

import com.badlogic.gdx.Game;

import java.util.ArrayList;

public class GOFactory
{
    public static SimpleEnemy createSimpleEnemy(float initX, float initY)
    {
        return new SimpleEnemy(initX,initY,1f,1f,"testEnemy");
    }

    public static GameBackground createBackground(float initX, float initY, float width, float height)
    {
        return new GameBackground(initX-width/2,initY-height/6,width,height);
    }

    public  static TurretBase createBaseForTurrets(float initX, float initY)
    {
        return new TurretBase(initX, initY, 0.75f,0.75f,"base");
    }

    public  static Turret createTurret(float initX, float initY, int type)
    {
        return new Turret(initX, initY, 0.75f,0.75f,"turret",type);
    }

    public static TurretBullet createTurretBullet(float initX, float initY, int type, float dirX, float dirY)
    {
        return new TurretBullet(initX, initY, 0.25f,0.25f,"bullet",type, dirX, dirY);
    }
}
