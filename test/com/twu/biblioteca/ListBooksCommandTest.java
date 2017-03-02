package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ListBooksCommandTest {
    ListBooksCommand listBooksCommand;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        Library library = new Library();
        listBooksCommand = new ListBooksCommand(library);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void listsBooksInLibrary() {
        listBooksCommand.execute();
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
