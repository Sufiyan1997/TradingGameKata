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

    public boolean drawCard() {
        if (deck.size() == 0) {
            health--;
            return true;
        }
        int index = random.nextInt(deck.size());
        int card = deck.remove(index);
        if(hand.size() < 5) {
            hand.add(card);
        }
        return true;
    }

    public void pickInitialHand() {
        for (int i = 0; i < 3; ++i) drawCard();
    }

    public void initializeTurn() {
        manaSlots++;
        mana = manaSlots;
        drawCard();
    }

    public void reduceHealth(int reduction) {
        health -= reduction;
    }

    public boolean hasLost() {
        return health <= 0;
    }

    public boolean canPlayAnyMove() {
        if(hand.isEmpty()) {
            return false;
        }

        for (int c : hand) {
            if (c <= mana) {
                return true;
            }
        }

        return false;
    }

    public boolean canPlayMove(int move) {
        if (!canPlayAnyMove()) {
            return false;
        }

        return hand.contains(move) && mana >= move;
    }

    public void performMove(int card, Player opponent) {
        if (!canPlayMove(card)) return;
        mana -= card;
        hand.remove(Integer.valueOf(card));
        opponent.reduceHealth(card);
    }

    public String getStatus() {
        return String.format("Name : %s\nAvailable Mana : %d\nManaslots : %d\nhealth : %d\nHand:%s", name, mana, manaSlots, health, Arrays.toString(hand.toArray()));
    }
}
