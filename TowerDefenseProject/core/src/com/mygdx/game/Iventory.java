package com.mygdx.game;

public class Iventory {
    public static  Iventory instance = null;
    public boolean haveKey=false;
    public int actualLVL=1;

    public static Iventory getInstance()
    {
        if (instance == null)
        {
            instance = new Iventory();
        }
        return instance;
    }
}
