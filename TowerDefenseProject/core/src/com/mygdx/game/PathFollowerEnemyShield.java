package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class PathFollowerEnemyShield extends GameObject
{
    Color tintColor;
    ArrayList<Vector2> waypoints;
    Vector2 currentTarget;
    float speed;
    int currentIndex;
    float rotation;
    float rotation2;
    boolean onRoute;
    boolean hasShield;

    int damage;
    int hp;
    int shieldHp;
    int gold;
    boolean dead;

    /**
     * You must provide a list of waypoints, the first one will be the
     * initial position and the list should have at least two points.
     * @param waypoints
     */
    PathFollowerEnemyShield(ArrayList<Vector2> waypoints)
    {
        this.setTag("enemyShield");
        this.waypoints = waypoints;
        this.speed = 1.5f;

        this.position = waypoints.get(0).cpy();
        this.currentTarget = waypoints.get(1);
        currentIndex = 1;
        this.onRoute = true;
        hasShield = true;

        double degrees = Math.atan2(currentTarget.y - position.y,currentTarget.x - position.x) * 180.0d / Math.PI;
        this.rotation = ((float) degrees)+270;
        //this.rotation = 270;

        this.damage = 2;
        this.hp = 10;
        this.shieldHp = 10;
        this.dead = false;
        this.gold = 100;

        tintColor = new Color(1.0f,0.0f,0.0f,0.5f);
    }

    private void move (float delta)
    {
        Vector2 step = this.currentTarget.cpy().sub(position).nor().scl(delta*this.speed);
        this.position.add(step);
    }

    @Override
    public void update(float delta) {
        if (onRoute)
        {
            move(delta);
        }
        nextWaypoint();

        rotation2 += 90*delta;
    }

    private void nextWaypoint()
    {
        if(position.dst(currentTarget) < Constants.TARGET_TRESHOLD)
        {
            if (currentIndex+1 < waypoints.size())
            {
                currentIndex++;
                currentTarget = waypoints.get(currentIndex);

                double degrees = Math.atan2(
                        currentTarget.y - position.y,
                        currentTarget.x - position.x
                ) * 180.0d / Math.PI;
                rotation = ((float) degrees)+270;
            }
            else
            {
                //Gdx.app.debug("PATH", "Path finalizado.");

                onRoute = false;
            }

        }
    }

    @Override
    public void render(SpriteBatch batch)
    {
        if (!dead)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.UFO),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation);
        }

        if (hasShield)
        {
            batch.draw(AssetManager.getInstance().getTRByEnum(AssetManager.TEXTURES.SHIELD),
                    position.x, position.y, dimension.x/2, dimension.y/2,
                    dimension.x, dimension.y,1,1, rotation2);
        }
    }

    @Override
    public void lookAt(Vector2 targetPosition) {

    }

    @Override
    public String toString() {
        return "PathFollowerEnemy{" +
                "position=" + position +
                ", dimension=" + dimension +
                ", waypoints=" + waypoints +
                ", currentTarget=" + currentTarget +
                ", speed=" + speed +
                '}';
    }

    public int recieveDamage(float damage, int damageType)
    {
        if(hasShield)
        {
            if (damageType == 1)
            {
                shieldHp -= damage;
            }
            if (shieldHp <= 0)
            {
                hasShield = false;
            }
        }

        if(!hasShield)
        {
            hp -= damage;
            if (hp <= 0)
            {
                dead = true;
                return gold;
            }
        }
        return 0;
    }

    public boolean isDead()
    {
        return dead;
    }
}
