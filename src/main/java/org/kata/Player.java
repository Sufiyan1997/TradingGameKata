package org.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    int mana;
    int manaSlots;
    int health;
    String name;
    List<Integer> deck;

    public Player(String name) {
        this.mana = 0;
        this.manaSlots = 0;
        this.health = 30;
        this.name = name;
        this.deck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
    }

    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    public int getManaSlots() {
        return manaSlots;
    }

    public int getHealth() {
        return health;
    }

    public List<Integer> getDeck() {
        return deck;
    }
}
