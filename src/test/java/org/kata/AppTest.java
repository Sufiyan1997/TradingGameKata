package org.kata;


import org.junit.Before;
import org.junit.Test;
import org.kata.UI.UI;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Player p1, p2;
    private App app;
    private UI ui;

    @Before
    public void setUp() throws Exception {
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        ui = mock(UI.class);
        app = new App(p1, p2, 1, ui);
    }

    @Test
    public void creatingAppShouldPickInitialHand() {
        verify(p1).pickInitialHand();
        verify(p2).pickInitialHand();
    }

    @Test
    public void setActivePLayerTest() {
        assertEquals(app.getActivePlayer(), p1);
        assertEquals(app.getInactivePlayer(), p2);
    }

    @Test
    public void getWinnerTest()
    {
        when(p1.hasLost()).thenReturn(true);
        when(p2.hasLost()).thenReturn(false);
        assertEquals(app.getWinner(), p2);
    }

    @Test
    public void swapPlayersTest() {
        Player activePlayerInitially = app.getActivePlayer();
        Player inactivePlayerInitially = app.getInactivePlayer();
        app.swapPlayers();
        assertEquals(activePlayerInitially, app.getInactivePlayer());
        assertEquals(inactivePlayerInitially, app.getActivePlayer());
    }

    @Test
    public void minusOneMoveShouldSwapPlayers() {
        Player activePlayerInitially = app.getActivePlayer();
        Player inactivePlayerInitially = app.getInactivePlayer();
        app.processMove(-1);
        assertEquals(activePlayerInitially, app.getInactivePlayer());
        assertEquals(inactivePlayerInitially, app.getActivePlayer());
    }

    @Test
    public void returnFalseWhenPlayerCannotPerformMove() {
        when(p1.canPlayMove(3)).thenReturn(false);
        assertFalse(app.processMove(3));
    }

    @Test
    public void callsPerformMoveOnPlayerWhenCanPerformMove() {
        when(p1.canPlayMove(3)).thenReturn(true);
        app.processMove(3);
        verify(p1).performMove(3, p2);
    }
}
