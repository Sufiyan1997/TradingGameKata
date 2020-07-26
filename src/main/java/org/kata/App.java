package org.kata;

import org.kata.UI.UI;

/**
 * Hello world!
 *
 */
public class App 
{
    private UI ui;
    public App(Player p1, Player p2, UI ui) {
        this.ui = ui;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
