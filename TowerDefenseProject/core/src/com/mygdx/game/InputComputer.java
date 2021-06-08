package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class InputComputer implements InputProcessor
{

    public final String tag = "COMPUTER INPUT";
    private Level level;
    private MainClass game;
    private MainMenu menuScreen;
    Vector3 point;

    public InputComputer(Level level)
    {
        this.level = level;

        menuScreen = new MainMenu(this.game);
        point = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        if (character == 'c')
        {
            level.cameraHelper.giveMeInfoAboutTheCam();
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        //This is the point in the screen.


        //Now the point is in world coordinates.
        //Gdx.app.debug(tag, "Han tocado " + screenX + " - " + screenY + " en el mundo es: " + point.x + "," + point.y +" en el ordenador.");
        //level.testTower(point.x, point.y,0);
        //level.testUFO(point.x, point.y);
        //level.createTower(point.x, point.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        point.set(screenX,screenY,0);

        level.camera.unproject(point);


        for(int i=0;i<level.buttonArrayList.size();i++)
        {
            if(level.buttonArrayList.get(i).CheckBounds(point.x,point.y))
            {
                AudioManager.getInstance().PlaySound(0);
            }
        }


        if(level.exitButton.CheckBounds(point.x,point.y))
        {
            level.changelvl=true;
        }


        if(level.musicButton.CheckBounds(point.x, point.y))
        {
            level.musicButton.musicON=!level.musicButton.musicON;

            if(!level.musicButton.musicON)
            {
                AudioManager.getInstance().MuteVolume();
            }
            else if(level.musicButton.musicON)
            {
                AudioManager.getInstance().DesmutedVolume();

            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        //Gdx.app.debug(tag, "Han drageado " + screenX + " - " + screenY + " - " + pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        //Gdx.app.debug(tag, "Han movido " + screenX + " - " + screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return false;
    }
}
