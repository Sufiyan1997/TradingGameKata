package org.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
}
