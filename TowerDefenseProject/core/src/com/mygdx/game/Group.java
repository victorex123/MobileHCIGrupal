package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Group
{
    ArrayList<GameObject> enemies;
    float timeBetweenEnemies;

    Group(ArrayList<GameObject> enemies)
    {
        this.enemies = enemies;
        this.timeBetweenEnemies = 1f;
    }

}
