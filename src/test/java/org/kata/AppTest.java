package org.kata;


import org.junit.Test;
import org.kata.UI.UI;
import static org.mockito.Mockito.*;

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
        App app = new App(p1, p2, ui);

        verify(p1).pickInitialHand();
        verify(p2).pickInitialHand();
    }
}
