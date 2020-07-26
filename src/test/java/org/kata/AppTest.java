package org.kata;


import org.junit.Test;
import org.kata.UI.UI;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void creatingAppShouldPickInitialHand() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        UI ui = mock(UI.class);
        App app = new App(p1, p2, 1, ui);

        verify(p1).pickInitialHand();
        verify(p2).pickInitialHand();
    }

    @Test
    public void setActivePLayerTest() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        UI ui = mock(UI.class);
        App app = new App(p1, p2, 1, ui);

        assertEquals(app.getActivePlayer(), p1);
        assertEquals(app.getInactivePlayer(), p2);
    }
}
