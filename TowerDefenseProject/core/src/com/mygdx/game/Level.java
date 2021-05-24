package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.rmi.dgc.DGC;
import java.util.ArrayList;
import java.util.Vector;

public class Level
{
    ArrayList<GameObject> gos;
    ArrayList<GameObject> inactiveGos;
    Wave wave;
    OrthographicCamera camera;
    CameraHelper cameraHelper;
    float timer;
    int enemyIterator;
    int groupIterator;

    int playerHP;
    int money;

    Level()
    {
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);
        camera.update();

        cameraHelper = new CameraHelper(camera);

        gos = new ArrayList<GameObject>();
        inactiveGos = new ArrayList<GameObject>();

        //Create background
        gos.add(GOFactory.createBackground(0,0,16,27));

        //Create the place where there is turrets
        gos.add(GOFactory.createBaseForTurrets(2.6625f-0.375f,-3.4625f-0.375f));
        gos.add(GOFactory.createTurret(2.6625f-0.375f,-3.4625f-0.375f,0));

        gos.add(GOFactory.createBaseForTurrets(0.66f-0.375f,0.125f-0.375f));
        gos.add(GOFactory.createTurret(0.66f-0.375f,0.125f-0.375f,0));

        gos.add(GOFactory.createBaseForTurrets(-6.3f-0.375f,2.5f-0.375f));
        gos.add(GOFactory.createTurret(-6.3f-0.375f,2.5f-0.375f,0));

        gos.add(GOFactory.createBaseForTurrets(-4.0875f-0.375f,5.289f-0.375f));
        gos.add(GOFactory.createTurret(-4.0875f-0.375f,5.289f-0.375f,1));

        gos.add(GOFactory.createBaseForTurrets(1.637f-0.375f,4.729f-0.375f));
        gos.add(GOFactory.createTurret(1.637f-0.375f,4.729f-0.375f,1));

        gos.add(GOFactory.createBaseForTurrets(5.21f-0.375f,8.069f-0.375f));
        gos.add(GOFactory.createBaseForTurrets(1.5f-0.375f,11.54f-0.375f));
        gos.add(GOFactory.createBaseForTurrets(-4.425f-0.375f,10.619f-0.375f));
        gos.add(GOFactory.createBaseForTurrets(4.925f-0.375f,13.128f-0.375f));
        gos.add(GOFactory.createBaseForTurrets(-0.8375f-0.375f,16.878f-0.375f));
        gos.add(GOFactory.createBaseForTurrets(-4.8625f-0.375f,17.078f-0.375f));

        //Create the routes that the enemies follow.
        //Route1
        ArrayList<Vector2> waypoints = new ArrayList<Vector2>();
        waypoints.add(new Vector2(-7.8125f,20.537394f));
        waypoints.add(new Vector2(-3.1f,17.924892f));
        waypoints.add(new Vector2(-3.7125f,13.844006f));
        waypoints.add(new Vector2(-2.4875002f,10.325123f));
        waypoints.add(new Vector2(-6.7125f,6.6562405f));
        waypoints.add(new Vector2(-4.725f,3.23651f));
        waypoints.add(new Vector2(-7.4f,-4.2310762f));
        waypoints.add(new Vector2(-20f,-20f));

        //Route2
        ArrayList<Vector2> waypoints2 = new ArrayList<Vector2>();
        waypoints2.add(new Vector2(1.6125002f,22.169357f));
        waypoints2.add(new Vector2(0.7250004f,19.656857f));
        waypoints2.add(new Vector2(-2.9625f,18.094357f));
        waypoints2.add(new Vector2(-3.4250002f,15.881689f));
        waypoints2.add(new Vector2(-3.775f,13.706689f));
        waypoints2.add(new Vector2(-2.4875002f,11.240719f));
        waypoints2.add(new Vector2(-3.3874998f,9.226476f));
        waypoints2.add(new Vector2(-5.1125f,7.2354813f));
        waypoints2.add(new Vector2(-5.55f,5.3582177f));
        waypoints2.add(new Vector2(-4.725f,3.6351256f));
        waypoints2.add(new Vector2(-4.95f,1.4351954f));
        waypoints2.add(new Vector2(-6.7375f,-3.6394145f));
        waypoints2.add(new Vector2(-20f,-20f));

        //Route3
        ArrayList<Vector2> waypoints3 = new ArrayList<Vector2>();
        waypoints3.add(new Vector2(7.2375f,16.662298f));
        waypoints3.add(new Vector2(5.0375004f,14.737299f));
        waypoints3.add(new Vector2(1.3874998f,14.074799f));
        waypoints3.add(new Vector2(2.3874998f,13.103517f));
        waypoints3.add(new Vector2(4.0625f,11.752287f));
        waypoints3.add(new Vector2(5.7375f,10.515304f));
        waypoints3.add(new Vector2(7.0874996f,8.990304f));
        waypoints3.add(new Vector2(7.1125f,6.7191734f));
        waypoints3.add(new Vector2(5.675f,5.3924503f));
        waypoints3.add(new Vector2(2.8999996f,6.54245f));
        waypoints3.add(new Vector2(0.33749962f,6.42995f));
        waypoints3.add(new Vector2(-1.1624999f,4.69245f));
        waypoints3.add(new Vector2(-0.2874999f,2.7771597f));
        waypoints3.add(new Vector2(1.75f,2.1021595f));
        waypoints3.add(new Vector2(2.625f,0.81171346f));
        waypoints3.add(new Vector2(2.1625004f,-0.91470003f));
        waypoints3.add(new Vector2(0.7124996f,-2.2522001f));
        waypoints3.add(new Vector2(-2.3874998f,-3.880653f));
        waypoints3.add(new Vector2(-20f,-20f));

        //Route4
        ArrayList<Vector2> waypoints4 = new ArrayList<Vector2>();
        waypoints4.add(new Vector2(1.6125002f,21.93749f));
        waypoints4.add(new Vector2(1.0f,19.99999f));
        waypoints4.add(new Vector2(1.0f,17.33398f));
        waypoints4.add(new Vector2(1.1125002f,14.908981f));
        waypoints4.add(new Vector2(2.3874998f,13.103517f));
        waypoints4.add(new Vector2(4.0625f,11.752287f));
        waypoints4.add(new Vector2(5.7375f,10.515304f));
        waypoints4.add(new Vector2(7.0874996f,8.990304f));
        waypoints4.add(new Vector2(7.1125f,6.7191734f));
        waypoints4.add(new Vector2(5.675f,5.3924503f));
        waypoints4.add(new Vector2(2.8999996f,6.54245f));
        waypoints4.add(new Vector2(0.33749962f,6.42995f));
        waypoints4.add(new Vector2(-1.1624999f,4.69245f));
        waypoints4.add(new Vector2(-0.2874999f,2.7771597f));
        waypoints4.add(new Vector2(1.75f,2.1021595f));
        waypoints4.add(new Vector2(2.625f,0.81171346f));
        waypoints4.add(new Vector2(2.1625004f,-0.91470003f));
        waypoints4.add(new Vector2(0.7124996f,-2.2522001f));
        waypoints4.add(new Vector2(-2.3874998f,-3.880653f));
        waypoints4.add(new Vector2(-20f,-20f));


        ArrayList<GameObject> group1 = new ArrayList<GameObject>();
        group1.add(new PathFollowerEnemy(waypoints4));
        group1.add(new PathFollowerEnemy(waypoints3));
        group1.add(new PathFollowerEnemy(waypoints3));
        group1.add(new PathFollowerEnemy(waypoints2));
        group1.add(new PathFollowerEnemy(waypoints));

        ArrayList<GameObject> group2 = new ArrayList<GameObject>();
        group2.add(new PathFollowerEnemy(waypoints4));
        group2.add(new PathFollowerEnemyShield(waypoints4));

        ArrayList<GameObject> group3 = new ArrayList<GameObject>();
        group3.add(new PathFollowerEnemy(waypoints4));
        group3.add(new PathFollowerEnemy(waypoints4));
        group3.add(new PathFollowerEnemy(waypoints4));
        group3.add(new PathFollowerEnemy(waypoints4));
        group3.add(new PathFollowerEnemyShield(waypoints4));
        group3.add(new PathFollowerEnemyShield(waypoints4));
        group3.add(new PathFollowerEnemyShield(waypoints4));
        group3.add(new PathFollowerEnemyShield(waypoints4));

        ArrayList<GameObject> group4 = new ArrayList<GameObject>();
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));
        group4.add(new PathFollowerEnemy(waypoints));
        group4.add(new PathFollowerEnemy(waypoints2));
        group4.add(new PathFollowerEnemy(waypoints3));
        group4.add(new PathFollowerEnemy(waypoints4));


        Group team1 = new Group(group1);
        Group team2 = new Group(group2);
        Group team3 = new Group(group3);
        Group team4 = new Group(group4);

        ArrayList<Group> teams = new ArrayList<Group>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        this.wave = new Wave(teams);

        this.timer = this.wave.groups.get(0).timeBetweenEnemies;
        this.timer = this.wave.groups.get(0).timeBetweenEnemies;

        this.groupIterator = 0;
        this.enemyIterator = 0;

        this.playerHP = 10;
        this.money = 150;

    }

    public void update(float delta)
    {
        for (GameObject go : gos)
        {
            go.update(delta);
        }
        //Countdown for waves
        timer -= delta;
        if (timer <= 0)
        {
            timer = spawnEnemy();
        }

        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "enemy")
            {
                //Gdx.app.log("ENEMYPOSITION","Nave X: " + gos.get(i).position.x +"-O-"+ gos.get(i).getPosition().x);
            }
        }

        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "enemy" || gos.get(i).getTag() == "enemyShield")
            {
                for (int j = 0; j < gos.size(); j++)
                {
                    if (gos.get(j).getTag() == "bullet" && gos.get(i).checkCollisionBullets(gos.get(j).getPosition().x,gos.get(j).getPosition().y))
                    {
                        if (gos.get(i).getTag() == "enemy")
                            money += ((PathFollowerEnemy) gos.get(i)).recieveDamage(Constants.GUN_TOWER_DAMAGE,((TurretBullet) gos.get(j)).getBulletType());
                        if (gos.get(i).getTag() == "enemyShield")
                            money += ((PathFollowerEnemyShield) gos.get(i)).recieveDamage(Constants.GUN_TOWER_DAMAGE,((TurretBullet) gos.get(j)).getBulletType());

                        ((TurretBullet) gos.get(j)).destroyBullet();
                        //Gdx.app.debug("DINEROS","Actual money: " + money);
                    }
                }
            }
        }


        towerShootingSystem(delta);
        cleanDestroyedUFOS();
        cleanUselessBullets();
        anEnemyReachTheEnd();

        cameraHelper.update(delta);
    }

    public void render(SpriteBatch batch)
    {
        for (GameObject  go : gos)
        {
            go.render(batch);
        }
    }

    public void createTestUFO(float x, float y)
    {
        gos.add(GOFactory.createSimpleEnemy(x-0.5f,y-0.5f));
    }
    public void testUFO(float x, float y)
    {
        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "testEnemy" && gos.get(i).checkCollisionWithRadius(x,y))
            {
                inactiveGos.add(gos.get(i));
                gos.remove(gos.get(i));
                return;
            }

        }
        createTestUFO(x,y);
    }

    public void createTower(float x, float y)
    {
        for (int i = 0; i < gos.size(); i++)
        {
            for (int j = 0; j < gos.size(); j++)
            {
                if (gos.get(j).getTag() == "turret" && gos.get(j).checkCollisionWithRadius(x,y))
                {
                    return;
                }
            }
            if (gos.get(i).getTag() == "base" && gos.get(i).checkCollisionWithRadius(x,y))
            {
                if ( money - 50 >= 0)
                {
                    money -= 50;
                    gos.add(GOFactory.createTurret(gos.get(i).getX(),gos.get(i).getY(),0));
                    Gdx.app.log("Construcción","Torre construida con éxito.");
                }
                else
                {
                    Gdx.app.log("Construcción","No tienes suficiente dinero para comprar una torre.");
                }

                return;
            }

        }
    }



    public void testTower(float x, float y, int towerType)
    {
        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "base" && gos.get(i).checkCollisionWithRadius(x,y))
            {
                if(towerType == 1)
                {
                    gos.add(GOFactory.createTurret(x-0.5f,y-0.5f,0));
                }
                if(towerType == 2)
                {
                    gos.add(GOFactory.createTurret(x-0.5f,y-0.5f,1));
                }
                return;
            }
        }
    }

    public float spawnEnemy()
    {
        for (int i = groupIterator; i < wave.groups.size(); i++)
        {
            for (int j = enemyIterator; j < wave.groups.get(i).enemies.size(); j++)
            {
                gos.add(wave.groups.get(i).enemies.get(j));
                //Gdx.app.log("SPAWN","Creo un bicho.");
                enemyIterator++;
                return  wave.groups.get(i).timeBetweenEnemies;
            }
            enemyIterator = 0;
            groupIterator++;
            return wave.timeBetweenGroups;
        }
        return wave.timeBetweenGroups;
    }

    public void anEnemyReachTheEnd()
    {
        for (int z = 0; z < gos.size(); z++)
        {
            if ((gos.get(z).getTag() == "enemy") && (gos.get(z).getPosition().x < -15 || gos.get(z).getPosition().y < -15))
            {
                playerHP -= Constants.NORMAL_ENEMY_DAMAGE;
                inactiveGos.add(gos.get(z));
                gos.remove(gos.get(z));
                Gdx.app.log("DAMAGE",Constants.NORMAL_ENEMY_DAMAGE+" --> Damage received.");
            }
            if ((gos.get(z).getTag() == "enemyShield") && (gos.get(z).getPosition().x < -15 || gos.get(z).getPosition().y < -15))
            {
                playerHP -= Constants.SHIELD_ENEMY_DAMAGE;
                inactiveGos.add(gos.get(z));
                gos.remove(gos.get(z));
                Gdx.app.log("DAMAGE",Constants.SHIELD_ENEMY_DAMAGE+" --> Damage received.");
            }
        }
        if(playerHP <= 0)
        {
            Gdx.app.log("DefeatMessage","YOU DIE.");
            playerHP = 9999999;
        }
    }

    public float calculateDistanceBetweenGameObjects(GameObject gameObject1, GameObject gameObject2)
    {
        return (float) Math.sqrt(Math.pow((gameObject2.position.x-gameObject1.position.x),2)+
                Math.pow((gameObject2.position.y-gameObject1.position.y),2));
    }

    public void cleanUselessBullets()
    {
        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "bullet")
            {
                if (((TurretBullet) gos.get(i)).isDead() == true)
                {
                    gos.remove(gos.get(i));
                    //Gdx.app.debug("BULLETS","Removed bullet.");
                }
            }
        }
    }

    public void cleanDestroyedUFOS()
    {
        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "enemy")
            {
                if (((PathFollowerEnemy) gos.get(i)).isDead() == true)
                {
                    gos.remove(gos.get(i));
                }
            }
            if (gos.get(i).getTag() == "enemyShield")
            {
                if (((PathFollowerEnemyShield) gos.get(i)).isDead() == true)
                {
                    gos.remove(gos.get(i));
                }
            }
        }
    }

    public void towerShootingSystem(float delta)
    {
        for (int i = 0; i < gos.size(); i++)
        {
            if (gos.get(i).getTag() == "turret")
            {
                for (int j = 0; j < gos.size(); j++)
                {
                    if ((gos.get(j).getTag() == "enemy" || gos.get(j).getTag() == "enemyShield") && calculateDistanceBetweenGameObjects(gos.get(i),gos.get(j)) < Constants.GUN_TOWER_RADIUS)
                    {
                        gos.get(i).lookAt(gos.get(j).getPosition());
                        if (((Turret) gos.get(i)).readyToShoot(delta))
                        {
                            gos.add(((Turret) gos.get(i)).shoot(gos.get(j).getPosition()));
                        }
                    }
                }
            }
        }
    }
}
