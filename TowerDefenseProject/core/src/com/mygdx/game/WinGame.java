package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WinGame implements Screen {
    MainClass game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture win;
    Texture backMenu;
    private float timeToGOMenuScreen;


    public WinGame(MainClass game)
    {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        win = AssetManager.getInstance().youWin;
        backMenu = AssetManager.getInstance().backMenu;
        //startGame = AssetManager.getInstance().startGame;
    }
    @Override
    public void show() {
        AudioManager.getInstance().PlayMusicWin();
    }

    @Override
    public void render(float delta) {

        timeToGOMenuScreen+=delta;

        if(Gdx.input.isTouched() && timeToGOMenuScreen>=1.0f)
        {
            game.setScreen(new MainMenu(game));
        }

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        //button.render(batch);
        batch.draw(win,-6,100,12,120);
        batch.draw(backMenu,-4,-50,8,80);
        //batch.draw(startGame,-4,-50,8,80);
        //font.draw(batch,"Click Anywhere to start",-camera.viewportWidth/2,0,camera.viewportWidth, Align.center,true);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT/height)*width;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
