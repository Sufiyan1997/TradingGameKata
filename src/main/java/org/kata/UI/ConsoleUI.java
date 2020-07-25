package org.kata.UI;

public class ConsoleUI implements UI{
    @Override
    public void message(String msg) {
        System.out.println(msg);
    }
}
