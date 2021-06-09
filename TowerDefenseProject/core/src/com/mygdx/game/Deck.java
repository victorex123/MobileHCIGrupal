package com.mygdx.game;

import java.util.ArrayList;

public class Deck
{
    ArrayList<Monster> cards;

    public void addCard(Monster newMonster)
    {
        cards.add(newMonster);
    }

    public void initDeck()
    {
        cards = new ArrayList<>();
    }

    public int getPower()
    {
        int totalPower = 0;
        for (int i = 0; i < cards.size(); i++)
        {
            totalPower += cards.get(i).getPower();
        }
        return totalPower;
    }

    public void killCard(int id)
    {
        cards.remove(id);
    }
}
