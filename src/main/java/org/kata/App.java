package org.kata;

import org.kata.UI.ConsoleUI;
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

    public void play() {
        while (true) {
            Player winner = getWinner();
            if (winner != null) {
                ui.message(winner.getName() + " Won");
                break;
            }

            activePlayer.initializeTurn();

            while (true) {

                ui.message("\n\n");
                ui.message("----CURRENT STATE----");
                ui.showState(this);
                ui.message("\n\n");
                if (!activePlayer.canPlayAnyMove()) {
                    ui.message(activePlayer.name + "can't play any card..swapping players");
                    swapPlayers();
                    break;
                }

                int move = ui.getMove();
                boolean result = processMove(move);

                if (!result) {
                    ui.message("Can't perform this move");
                }

                if (move == -1) {
                    break;
                }
            }

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

    public void swapPlayers() {
        Player tmp = activePlayer;
        activePlayer = inactivePlayer;
        inactivePlayer = tmp;
    }

    public boolean processMove(int move) {
        if (move == -1) {
            swapPlayers();
            return true;
        }

        if(!activePlayer.canPlayMove(move)) {
            return false;
        }

        activePlayer.performMove(move, inactivePlayer);
        return true;
    }

    public static void main( String[] args )
    {
        Player p1 = new Player("abc");
        Player p2 = new Player("def");

        App app = new App(p1, p2, 1, new ConsoleUI());
        app.play();
    }
}
