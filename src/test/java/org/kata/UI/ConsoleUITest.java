package org.kata.UI;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
}
