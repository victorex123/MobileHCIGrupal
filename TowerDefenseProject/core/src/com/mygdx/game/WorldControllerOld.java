package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class WorldControllerOld {

    ArrayList<Sprite> sprites;

    OrthographicCamera camera;

    Level level;

    int selectedSprite;
    boolean pause;
    float cameraX, cameraY;

    public WorldControllerOld(){
        sprites = new ArrayList<Sprite>();
        //init();

        level = new Level();
    }

    public void init(){

        sprites.clear();
        for (int i = 0; i < Constants.NUMBER_SPRITE; i++){
            if (i % 2 != 0)
            {
                sprites.add(SpriteHelper.getSpriteFromAtlasA());
            }
            if (i % 2 == 0)
            {
                sprites.add(SpriteHelper.getSpriteFromAtlasB());
            }

        }
        selectedSprite = 0;
        cameraX = 0;
        cameraY = 0;
        pause = false;

    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public void update(float delta){

        if (Gdx.input.isKeyJustPressed(Input.Keys.P))
        {
            pause = !pause;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.R))
        {
            init();
        }

        if (!pause)
        {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                if (selectedSprite >= sprites.size()-1)
                {
                    selectedSprite = 0;
                }
                else
                {
                    selectedSprite++;
                }
            }

            if(Gdx.input.isKeyJustPressed(Input.Keys.C))
            {
                sprites.get(selectedSprite).setColor(MathUtils.random(0f,1f),MathUtils.random(0f,1f),MathUtils.random(0f,1f),1f);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.A)){
                sprites.get(selectedSprite).translateX(-Constants.SPRITE_SPEED*delta);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.D)){
                sprites.get(selectedSprite).translateX(Constants.SPRITE_SPEED*delta);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.W)){
                sprites.get(selectedSprite).translateY(Constants.SPRITE_SPEED*delta);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
                sprites.get(selectedSprite).translateY(-Constants.SPRITE_SPEED*delta);
            }
            //sprites.get(selectedSprite).setRotation(sprites.get(selectedSprite).getRotation()+-360f*delta);

            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                camera.position.mulAdd(new Vector3(-1f,0f,0f),Constants.CAMERA_SPEED*delta);
                camera.update();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                camera.position.mulAdd(new Vector3(1f,0f,0f),Constants.CAMERA_SPEED*delta);
                camera.update();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                camera.position.mulAdd(new Vector3(0f,1f,0f),Constants.CAMERA_SPEED*delta);
                camera.update();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                camera.position.mulAdd(new Vector3(0f,-1f,0f),Constants.CAMERA_SPEED*delta);
                camera.update();
            }
        }

        level.update(Gdx.graphics.getDeltaTime());

    }
}
