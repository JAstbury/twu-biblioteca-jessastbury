package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ExitCommandTest {
    ExitCommand exitCommand;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        Biblioteca biblioteca = mock(Biblioteca.class);
        exitCommand = new ExitCommand(biblioteca);
    }

    @Test
    public void saysGoodbyeToUser () {
        exitCommand.execute();
        String expectedOutput  = "Goodbye!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}
