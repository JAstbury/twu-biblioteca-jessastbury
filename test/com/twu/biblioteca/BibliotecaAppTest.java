package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.io.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class BibliotecaAppTest {

    BibliotecaApp biblioteca;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void welcomeMessage() {
        biblioteca.welcomeMessage();
        String expectedOutput  = "Hello, welcome to Biblioteca!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void menuDisplay() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        biblioteca.giveMenuOptions();
        String expectedOutput  = "Please choose from these options:\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void getsUserChoice() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1", biblioteca.getUserChoice());
    }

    @Test
    public void listsBooksIfUserPicksOne() {
        biblioteca.selectsMenuOption("1");
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertEquals(expectedOutput, outContent.toString());
    }

   @Test
    public void callsCheckoutMethodIfUserPicksTwo() {
       String input = "Moby Dick";
       System.setIn(new ByteArrayInputStream(input.getBytes()));
       biblioteca.selectsMenuOption("2");
       String expectedOutput = "What is the title of the book you'd like to check out?\n";
       assertThat(outContent.toString(), containsString(expectedOutput));
   }

    @Test
    public void callsReturnMethodIfUserPicksThree() {
        String input = "Moby Dick";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.selectsMenuOption("3");
        String expectedOutput  = "What is the title of the book you'd like to return?\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfInvalidChoice() {
        biblioteca.selectsMenuOption("T");
        String expectedOutput  = "Select a valid option!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void exitsIfChoiceIsTwo() {
        biblioteca.selectsMenuOption("4");
        String expectedOutput  = "Goodbye!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }
}
