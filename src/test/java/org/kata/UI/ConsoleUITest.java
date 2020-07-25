package org.kata.UI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleUITest {
    private PrintStream sysOut;
    private ByteArrayOutputStream baos;

    @Before
    public void setUp() throws Exception {
        sysOut = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test
    public void messageTest() {
        UI ui = new ConsoleUI();
        ui.message("abc");
        assertEquals(baos.toString(), "abc\n");
    }

    @Test
    public void keepAskingTillCorrectInput() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("b\n5\n".getBytes());
        InputStream sysIn = System.in;
        System.setIn(byteArrayInputStream);

        UI ui = new ConsoleUI();
        int move = ui.getMove();
        assertEquals(baos.toString(), "Invalid input\n");
        assertEquals(move, 5);

        System.setIn(sysIn);
    }
}
