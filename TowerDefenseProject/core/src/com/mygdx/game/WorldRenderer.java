package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

    SpriteBatch batch;
    Level level;

    public WorldRenderer(Level level){
        this.level = level;
        batch = new SpriteBatch();
        init();
    }

    public void init()
    {

    }

    public void render(){

        //Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.setProjectionMatrix(level.camera.combined);
        batch.begin();

        level.render(batch);

        batch.end();
        //Gdx.app.debug("BATCH","Max sprites: " + batch.maxSpritesInBatch + " - render calls: " + batch.renderCalls);

    }

    public void resize(int width, int height){

        Gdx.app.debug("LIFECYCLE", "Width: " + width + " - Height: " + height);

        level.camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height)*width;
        level.camera.update();
    }

    public void dispose(){
        batch.dispose();
    }
}
