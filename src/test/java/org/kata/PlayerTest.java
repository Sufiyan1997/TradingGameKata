package org.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void playerInitializationTest() {
        Player player = new Player("abc");
        assertEquals(player.getName(), "abc");
        assertEquals(player.getHealth(), 30);
        assertEquals(player.getMana(), 0);
        assertEquals(player.getManaSlots(), 0);

        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        assertTrue(player.getDeck().equals(initialDeck));
    }

    @Test
    public void playerCannotDrawCardIfHandfullTest() {
        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        List<Integer> initialHand = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Player player = new Player(0, 0, 30, "abc", initialDeck, initialHand);
        assertFalse(player.canDrawCard());
    }

    @Test
    public void playerCannotDrawCardIfDeckEmptyTest() {
        List<Integer> initialDeck = new ArrayList<Integer>(new ArrayList<Integer>());
        List<Integer> initialHand = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        Player player = new Player(0, 0, 30, "abc", initialDeck, initialHand);
        assertFalse(player.canDrawCard());
    }

    @Test
    public void playerCanDrawIfHandNotFullAndDeckNotEmpty() {
        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        List<Integer> initialHand = new ArrayList<Integer>(new ArrayList<Integer>());
        Player player = new Player(0, 0, 30, "abc", initialDeck, initialHand);
        assertTrue(player.canDrawCard());
    }

    @Test
    public void drawCardTest() {
        Player player = new Player("abc");
        player.drawCard();

        assertEquals(player.getHand().size(), 1);
        assertEquals(player.getDeck().size(), 19);

        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        int drawnCard = player.getHand().get(0);
        player.getDeck().add(drawnCard);
        Collections.sort(player.getDeck());

        assertTrue(initialDeck.equals(player.getDeck()));
    }

    @Test
    public void pickInitialHandTest() {
        Player player = new Player("abc");
        player.pickInitialHand();
        assertEquals(player.getHand().size(), 3);
    }

    @Test
    public void initializeTurnTest() {
        Player player = new Player("abc");
        int initialHandSize = player.getHand().size();
        int initialManaSlots = player.getManaSlots();

        player.initializeTurn();

        assertEquals(player.getManaSlots(), initialManaSlots+1);
        assertEquals(player.getMana(), player.getManaSlots());
        assertEquals(player.getHand().size(), initialHandSize + 1);
    }

    @Test
    public void reduceHealthTest() {
        Player player = new Player("abc");
        int initialHealth = player.getHealth();
        player.reduceHealth(5);
        assertEquals(player.getHealth()+5, initialHealth);
    }

    @Test
    public void hasLostTest() {
        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        List<Integer> initialHand = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Player player = new Player(0, 0, 0, "abc", initialDeck, initialHand);
        assertTrue(player.hasLost());
        player.reduceHealth(1);
        assertTrue(player.hasLost());
    }

    @Test
    public void cannotPerformMoveIfHandIsEmpty() {
        List<Integer> initialDeck = new ArrayList<Integer>(Arrays.asList(0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8));
        List<Integer> initialHand = new ArrayList<Integer>(new ArrayList<Integer>());
        Player player = new Player(0, 0, 30, "abc", initialDeck, initialHand);
        assertFalse(player.canPlayAnyMove());
    }
}
