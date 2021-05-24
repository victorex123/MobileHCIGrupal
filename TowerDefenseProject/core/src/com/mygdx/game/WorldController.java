package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class WorldController {

    Level level;

    boolean pause;

    public WorldController(Level level)
    {
        init();
        this.level = level;
    }

    public void init()
    {
        pause = false;
    }

    public void update(float delta)
    {


        /*if (!pause)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.W)){}
            if(Gdx.input.isKeyPressed(Input.Keys.A)){}
            if(Gdx.input.isKeyPressed(Input.Keys.S)){}
            if(Gdx.input.isKeyPressed(Input.Keys.D)){}

            if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_ADD)){
                level.camera.zoom += 0.1f * delta;
                level.camera.update();
            }

            if(Gdx.input.isKeyPressed(Input.Keys.NUMPAD_SUBTRACT)){
                level.camera.zoom -= 0.1f * delta;
                level.camera.update();
            }
        }*/
        level.update(Gdx.graphics.getDeltaTime());
    }
}
