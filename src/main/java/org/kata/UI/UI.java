package org.kata.UI;

import org.kata.App;

public interface UI {
    public void message(String msg);
    public int getMove();
    public void showState(App app);
}
