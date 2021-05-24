package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Turret extends GameObject
{
    float rotation;
    float attackRadius;
    int turretType;
    float shootTime;
    float shootTimer;

    GameObject currentTarget;
    boolean attacking;

    public Turret(float x, float y, float width, float height, String tag, int type)
    {
        super(x,y,width,height,tag);
        this.rotation = 0;
        this.turretType = type;
        this.attackRadius = 25f;
        this.shootTime = 0.15f;
        this.shootTimer = this.shootTime;
        currentTarget = null;
        attacking = true;

    }

    @Override
    public void update(float delta)
    {
        if (currentTarget == null )
        {
            //this.rotation += 90*delta;
        }
    }

    @Override
    public void render(SpriteBatch batch) {

        if (turretType == 0)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.GUN),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation);
        }
        if (turretType == 1)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.LASERTURRET),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation);
        }
    }

    @Override
    public void lookAt(Vector2 targetPosition)
    {
        double degrees = Math.atan2(targetPosition.y - position.y,targetPosition.x - position.x) * 180.0d / Math.PI;
        this.rotation = ((float) degrees)+270;
    }

    public TurretBullet shoot(Vector2 targetPosition)
    {
        attacking = true;
        return GOFactory.createTurretBullet(this.getX(),this.getY(),turretType,targetPosition.x,targetPosition.y);
    }

    public boolean readyToShoot(float delta)
    {
        if (attacking)shootTimer -= delta;
        if(shootTimer <= 0)
        {
            shootTimer = shootTime;
            attacking = false;
            return true;
        }
        return false;
    }

    public float calculateDistance(float otherX, float otherY)
    {
        return (float) Math.sqrt(Math.pow((otherX-getX()),2)+Math.pow((otherY-getY()),2));
    }


}
