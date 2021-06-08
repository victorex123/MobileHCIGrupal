package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class InputMobile implements GestureDetector.GestureListener
{
    public final String tag = "MOBILE INPUT";

    private Level level;
    Vector3 point;

    public InputMobile(Level level)
    {
        this.level = level;
        point = new Vector3();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button)
    {
        //This is the point in the screen.
        point.set(x,y,0);

        level.camera.unproject(point);

        if(level.exitButton.CheckBounds(point.x,point.y))
        {
            AudioManager.getInstance().PlaySound(0);
            level.changelvl=true;
        }

        //close panel look
        if(level.actionLookLvl.buttonClose.CheckBounds(point.x,point.y) && level.actionLookLvl.detectSomething)
        {
            level.actionLookLvl.ClosePanelLook();
            AudioManager.getInstance().PlaySound(0);
        }
        if(level.upLvlButton.CheckBounds(point.x,point.y) && Iventory.getInstance().haveKey)
        {
            level.upLevel.ClimbLvl();
            level.actionLookLvl.ClosePanelLook();
            AudioManager.getInstance().PlaySound(0);
            if(Iventory.getInstance().actualLVL==4)
            {
                level.winTheGame=true;
            }
        }

        //open panel look
        if(level.lookLvlButton.CheckBounds(point.x,point.y) && !level.actionLookLvl.detectSomething)
        {
            level.actionLookLvl.CalculateThingToFind();
            AudioManager.getInstance().PlaySound(0);
        }

        //mute and desmute music
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
            AudioManager.getInstance().PlaySound(0);
        }

        //Now the point is in world coordinates.
        Gdx.app.debug(tag, "Han tocado " + x + " - " + y + " en el mundo es: " + point.x + "," + point.y +" en el móvil.");
       // level.createTower(point.x, point.y);
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button)
    {
        if (count == 3)
        {
            point.set(x,y,0);
            level.camera.unproject(point);

           // level.createTower(point.x, point.y);
        }
        return false;
    }

    @Override
    public boolean longPress(float x, float y)
    {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button)
    {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY)
    {
        //Gdx.app.debug(tag,"Pos inicial: "+x+","+y+" -> Pos final: "+deltaX+","+deltaY);
        if (((level.camera.position.x+(Constants.VIEWPORT_WIDTH-level.camera.viewportWidth)/2-deltaX*0.01f) >= 0) &&
                ((level.camera.position.x+level.camera.viewportWidth+(Constants.VIEWPORT_WIDTH-level.camera.viewportWidth)/2-deltaX*0.01f) <= 16)
        )
        {
            level.camera.translate(-deltaX*0.01f,0);
            level.camera.update();
        }
        if(((level.camera.position.y+level.camera.viewportHeight+(Constants.VIEWPORT_HEIGHT-level.camera.viewportHeight)/2+deltaY*0.01f) <= 27) &&
        ((level.camera.position.y+(Constants.VIEWPORT_HEIGHT-level.camera.viewportHeight)/2+deltaY*0.01f) >= 0)
        )
        {
            level.camera.translate(0,deltaY*0.01f);
            level.camera.update();
        }
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button)
    {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance)
    {
        //Do zoom
        if ((distance - initialDistance > 0) && ((level.camera.viewportHeight-Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001) > Constants.MIN_CAMERA_ZOOM_HEIGHT))
        //if ((distance - initialDistance > 0) && (level.camera.viewportHeight+Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001 < Constants.VIEWPORT_HEIGHT))
        {
            //Gdx.app.log(tag,"ZOOM");
            level.camera.viewportWidth -= Constants.CAMERA_ZOOM_SPEED*16*(distance-initialDistance)*0.0001;
            level.camera.viewportHeight -= Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001;
            level.camera.update();
        }
        //Reduce zoom
        //if ((distance - initialDistance < 0) && (level.camera.viewportHeight-Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001) > Constants.MIN_CAMERA_ZOOM_HEIGHT)
        if ((distance - initialDistance < 0) && (level.camera.viewportHeight+Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001 < Constants.VIEWPORT_HEIGHT))
        {
            //Gdx.app.log(tag,"ANTIZOOM");
            level.camera.viewportWidth -= Constants.CAMERA_ZOOM_SPEED*16*(distance-initialDistance)*0.0001;
            level.camera.viewportHeight -= Constants.CAMERA_ZOOM_SPEED*9*(distance-initialDistance)*0.0001;

            if(level.camera.position.x < 0)
            {
                //Gdx.app.log(tag,"PROBLEMA EN X NEGATIVA");
                //level.camera.translate(Constants.CAMERA_ZOOM_SPEED*16*0.0001f,0);
                level.camera.position.set(0,level.camera.position.y,0);
            }
            if (level.camera.position.x + level.camera.viewportWidth + (Constants.VIEWPORT_WIDTH-level.camera.viewportWidth)/2 +Constants.CAMERA_ZOOM_SPEED*0.0001f > 16)
            {
                //Gdx.app.log(tag,"PROBLEMA EN X EXCESIVA");
                //level.camera.translate(-Constants.CAMERA_ZOOM_SPEED*16*0.0001f,0);
                level.camera.position.set(0,level.camera.position.y,0);
            }
            if(level.camera.position.y < 0)
            {
                //Gdx.app.log(tag,"PROBLEMA EN Y NEGATIVA");
                //level.camera.translate(0,Constants.CAMERA_ZOOM_SPEED*9*0.0001f);
                level.camera.position.set(level.camera.position.x,0,0);
            }
            if(level.camera.position.y+level.camera.viewportHeight+(Constants.VIEWPORT_HEIGHT-level.camera.viewportHeight)/2+Constants.CAMERA_SPEED*0.0001f > 27)
            {
                //Gdx.app.log(tag,"PROBLEMA EN Y EXCESIVA");
                //level.camera.translate(0,-Constants.CAMERA_ZOOM_SPEED*9*0.0001f);
                level.camera.position.set(level.camera.position.x,18,0);
            }

            level.camera.update();
        }

        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2)
    {
        return false;
    }

    @Override
    public void pinchStop()
    {

    }
}
