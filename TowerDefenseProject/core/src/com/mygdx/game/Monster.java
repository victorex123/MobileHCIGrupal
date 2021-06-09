package com.mygdx.game;

public class Monster
{
    int id;
    String name;
    String description;
    int power;
    boolean mercenary;

   public Monster(int id, String name, String description, int power, boolean mercenary)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.power = power;
        this.mercenary = mercenary;
    }

    public int getId(){return  id;}
    public String getName(){return  name;}
    public String getDescription(){return  description;}
    public int getPower(){return  power;}
    public boolean getMercenary(){return  mercenary;}
}
