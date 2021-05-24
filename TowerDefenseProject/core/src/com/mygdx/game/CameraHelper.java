package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import java.util.Iterator;

public class CameraHelper
{
    OrthographicCamera camera;
    GameObject target;

    CameraHelper(OrthographicCamera camera)
    {
        this.camera = camera;
        target = null;
    }

    public void followThatGuy(GameObject target)
    {
        this.target = target;
    }

    public void stopFollowing()
    {
        target = null;
    }

    public void update(float delta)
    {
        if(target != null)
        {
            this.camera.position.set(target.position.x, target.position.y, 0);
            this.camera.update();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && (this.camera.position.x+(Constants.VIEWPORT_WIDTH-this.camera.viewportWidth)/2-Constants.CAMERA_SPEED*delta) >= 0){
            camera.translate(-Constants.CAMERA_SPEED * delta, 0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (this.camera.position.x+this.camera.viewportWidth+(Constants.VIEWPORT_WIDTH-this.camera.viewportWidth)/2+Constants.CAMERA_SPEED*delta) <= 16){
            camera.translate(Constants.CAMERA_SPEED * delta, 0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && (this.camera.position.y+this.camera.viewportHeight+(Constants.VIEWPORT_HEIGHT-this.camera.viewportHeight)/2+Constants.CAMERA_SPEED*delta) <= 27){
            camera.translate(0,Constants.CAMERA_SPEED * delta);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && (this.camera.position.y+(Constants.VIEWPORT_HEIGHT-this.camera.viewportHeight)/2-Constants.CAMERA_SPEED*delta) >= 0){
            camera.translate(0,-Constants.CAMERA_SPEED * delta);
            camera.update();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_ADD) && (camera.viewportHeight-Constants.CAMERA_ZOOM_SPEED*9*delta) >= Constants.MIN_CAMERA_ZOOM_HEIGHT)
        {
            camera.viewportWidth -= Constants.CAMERA_ZOOM_SPEED*16*delta;
            camera.viewportHeight -= Constants.CAMERA_ZOOM_SPEED*9*delta;
            camera.update();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_SUBTRACT) && (camera.viewportHeight+Constants.CAMERA_ZOOM_SPEED*9*delta) <= Constants.VIEWPORT_HEIGHT)
        {
            camera.viewportWidth += Constants.CAMERA_ZOOM_SPEED*16*delta;
            camera.viewportHeight += Constants.CAMERA_ZOOM_SPEED*9*delta;
            if(camera.position.x < 0)
            {
                camera.translate(Constants.CAMERA_ZOOM_SPEED*16*delta,0);
            }
            if (camera.position.x + camera.viewportWidth + (Constants.VIEWPORT_WIDTH-this.camera.viewportWidth)/2 +Constants.CAMERA_ZOOM_SPEED*delta > 16)
            {
                camera.translate(-Constants.CAMERA_ZOOM_SPEED*16*delta,0);
            }
            if(camera.position.y < 0)
            {
                camera.translate(0,Constants.CAMERA_ZOOM_SPEED*9*delta);
            }
            if(camera.position.y+camera.viewportHeight+(Constants.VIEWPORT_HEIGHT-this.camera.viewportHeight)/2+Constants.CAMERA_SPEED*delta > 27)
            {
                camera.translate(0,-Constants.CAMERA_ZOOM_SPEED*9*delta);
            }
            camera.update();
        }
    }

    public void giveMeInfoAboutTheCam()
    {
        Gdx.app.debug("CAMERA", this.camera.viewportWidth+" "+this.camera.viewportHeight+" "+this.camera.position);
    }
}
