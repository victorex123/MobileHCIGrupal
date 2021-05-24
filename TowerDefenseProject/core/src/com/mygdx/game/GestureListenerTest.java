package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class GestureListenerTest implements GestureDetector.GestureListener
{
    public final String tag = "GESTURES";

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        Gdx.app.debug(tag, "Han tocado " + x + " - " + y + " - " + pointer + " - " + button);
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        Gdx.app.debug(tag, "Tap " + x + " - " + y + " - Count: " + count + " - " + button);
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        Gdx.app.debug(tag, "Han hecho longPress " + x + " - " + y);
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        Gdx.app.debug(tag, "Han flingeado " + velocityX + " - " + velocityY + " - " + button);
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        Gdx.app.debug(tag, "Han pan " + x + " - " + y + " - "+ deltaX + " - " + deltaY);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        Gdx.app.debug(tag, "Han parado el pan " + x + " - " + y + " - "+ pointer + " - " + button);
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        Gdx.app.debug(tag, "Han hecho zoom " + initialDistance + " - " + distance);
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        Gdx.app.debug(tag, "Han pinch, initial " + initialPointer1 + " - " + initialPointer2 + " - "
                + pointer1 + " - " + pointer2);
        return false;
    }

    @Override
    public void pinchStop() {
        Gdx.app.debug(tag, "Han terminado el pinch.");

    }
}
