package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MainClass extends Game {
    MainMenu menuScreen;
    Sandbox gameScreen;
    @Override
    public void create() {
        menuScreen = new MainMenu(this);
        gameScreen = new Sandbox(this);

        setScreen(menuScreen);
    }


}
