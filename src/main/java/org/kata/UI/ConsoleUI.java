package org.kata.UI;

import org.kata.App;

import java.util.Scanner;

public class ConsoleUI implements UI{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }

    @Override
    public int getMove() {
        while (true) {
            String line = scanner.nextLine();
            try {
                int move = Integer.parseInt(line);
                return move;
            }
            catch (NumberFormatException e) {
                message("Invalid input");
            }
        }
    }

    @Override
    public void showState(App app) {
        message(app.getActivePlayer().getStatus());
        message(app.getInactivePlayer().getStatus());
        message("It is "+app.getActivePlayer().getName()+"'s turn");
    }
}
