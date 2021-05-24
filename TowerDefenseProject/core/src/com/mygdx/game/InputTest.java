package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class InputTest implements InputProcessor
{

    public final String tag = "INPUT";
    private Level level;
    Vector3 point;

    public InputTest(Level level)
    {
        this.level = level;
        point = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode) {
        //Gdx.app.debug(tag, "Han pulsado la tecla " + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        //Gdx.app.debug(tag, "Han soltado la tecla " + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        //Gdx.app.debug(tag, "Han escrito el caracter " + character);
        if (character == 'f')
        {
            level.cameraHelper.followThatGuy(level.gos.get(0));
        }
        if (character == 'q')
        {
            level.cameraHelper.stopFollowing();
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        //This is the point in the screen.
        point.set(screenX,screenY,0);

        level.camera.unproject(point);

        //Now the point is in world coordinates.
        Gdx.app.debug(tag, "Han tocado " + screenX + " - " + screenY + " en el mundo es: " + point.x + "," + point.y +" en el ordenador.");
        level.createTestUFO(point.x,point.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        //Gdx.app.debug(tag, "Han levantado " + screenX + " - " + screenY + " - " + pointer + " - " + button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //Gdx.app.debug(tag, "Han drageado " + screenX + " - " + screenY + " - " + pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        //Gdx.app.debug(tag, "Han movido " + screenX + " - " + screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
