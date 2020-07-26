package org.kata;

import org.kata.UI.UI;

/**
 * Hello world!
 *
 */
public class App 
{
    private UI ui;

    Player activePlayer, inactivePlayer;

    public App(Player p1, Player p2, int initialPlayer, UI ui) {
        this.ui = ui;

        p1.pickInitialHand();
        p2.pickInitialHand();

        if (initialPlayer == 1) {
            activePlayer = p1;
            inactivePlayer = p2;
        }
        else {
            activePlayer = p2;
            inactivePlayer = p1;
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getInactivePlayer() {
        return inactivePlayer;
    }

    public Player getWinner() {
        if ( activePlayer.hasLost() ) {
            return inactivePlayer;
        }
        else if (inactivePlayer.hasLost()) {
            return activePlayer;
        }
        return null;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
