package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Wave
{
    ArrayList<Group> groups;
    float timeBetweenGroups;

    Wave(ArrayList<Group> groups)
    {
        this.groups = groups;
        this.timeBetweenGroups = 4f;
    }
}
