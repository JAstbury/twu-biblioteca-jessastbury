package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ListMoviesCommandTest {
    ListMoviesCommand listMoviesCommand;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        Library library = new Library();
        listMoviesCommand = new ListMoviesCommand(library);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void listsBooksInLibrary() {
        listMoviesCommand.execute();
        String expectedOutput  = "Pulp Fiction | 1994 | Quentin Tarantino | 9\n" +
                "Inception | 2010 | Christopher Nolan | 8\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
