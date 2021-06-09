package com.mygdx.game;

import java.util.ArrayList;

public class MonsterManager
{
    //HUMANS
    Monster king;
    Monster queen;
    Monster knight;
    Monster archer;
    Monster angryFarmer;



    public Monster getKing()
    {
        return this.king = new Monster(1, "King", "The ruler of the kingdom.", 5, false);
    }
    public Monster getQueen()
    {
        return this.knight = new Monster(2, "Queen", "The couple of the King", 4, false);
    }
    public Monster getKnight()
    {
        return this.knight = new Monster(0, "Knight", "A veteran soldier.", 3, false);
    }
    public Monster getArcher()
    {
        return this.knight = new Monster(3, "Archer", "A veteran soldier.", 2, false);
    }
    public Monster getAngryFarmer()
    {
        return this.knight = new Monster(4, "Knight", "An angry commoner", 1, false);
    }

    //GOBLINS
    Monster orcLeader, assasssinGoblin, killerGoblin, thugGoblin, weakGoblin;
    public Monster getOrcLeader()
    {
        return this.orcLeader = new Monster(5, "Orc leader", "A violent green creature", 5, false);
    }
    public Monster getAssasssinGoblin()
    {
        return this.assasssinGoblin = new Monster(6, "Assassin goblin", "An assassin little green creature", 4, false);
    }
    public Monster getKillerGoblin()
    {
        return this.killerGoblin = new Monster(7, "Killer goblin", "A killer green creature", 3, false);
    }
    public Monster getThugGoblin()
    {
        return this.thugGoblin = new Monster(8, "Thug goblin", "A big green creature", 2, false);
    }
    public Monster getWeakGoblin()
    {
        return this.weakGoblin = new Monster(9, "Weak goblin", "A harmless little green creature", 1, false);
    }

    //MERCENARIES
    Monster mercenary;
    public Monster  getMercenary()
    {
        return this.mercenary = new Monster(10, "Mercenary", "Someone who only thinks about money",3,true);
    }


    //SPECIAL
    Monster blackDragon;
    public Monster getBlackDragon()
    {
        return this.blackDragon = new Monster(11, "Black Dragon", "The most powerful creature", 999, false);
    }

    public Monster getMonsterByID(int id)
    {
        switch (id)
        {
            case 5:
                return getOrcLeader();
            case 6:
                return getAssasssinGoblin();
            case 7:
                return getKillerGoblin();
            case 8:
                return getThugGoblin();
            case 9:
                return getWeakGoblin();
            case 10:
                return getMercenary();
            case 11:
                return getBlackDragon();
        }
        return null;
    }
}
