package org.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    int mana;
    int manaSlots;
    int health;
    String name;
    List<Integer> deck;
    List<Integer> hand;

    private static final Random random = new Random();

    public Player(String name) {
        this(0, 0, 30, name, new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8)), new ArrayList<Integer>());
    }

    public Player(int mana, int manaSlots, int health, String name, List<Integer> deck, List<Integer> hand) {
        this.mana = mana;
        this.manaSlots = manaSlots;
        this.health = health;
        this.name = name;
        this.deck = deck;
        this.hand = hand;
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

    public List<Integer> getHand() {
        return hand;
    }

    public boolean canDrawCard() {
        if (hand.size() == 5 || deck.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean drawCard() {
        if (!canDrawCard()) {
            return false;
        }
        int index = random.nextInt(deck.size());
        hand.add(deck.remove(index));
        return true;
    }

    public void pickInitialHand() {

    }
}
