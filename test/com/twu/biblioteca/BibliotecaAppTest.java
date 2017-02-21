package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.not;
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
    public void listBooks() {
        biblioteca.listBooks();
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void menuDisplay() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        biblioteca.menuDisplay();
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

//Commented out until I can figure out how to add Mockito to the project.
//    @Test
//    public void listsBooksIfUserPicksOne() {
//        BibliotecaApp bMock = Mockito.spy(new BibliotecaApp());
//        bMock.selectsMenuOption("1");
//        verify(bMock, times(1)).listBooks();
//    }
//
//   @Test
//    public void callsCheckoutMethodIfUserPicksTwo() {
//        BibliotecaApp bMock = Mockito.spy(new BibliotecaApp());
//        bMock.selectsMenuOption("2");
//        verify(bMock, times(1)).checkOut();
//    }

    @Test
    public void userNotifiedOfInvalidChoice() {
        biblioteca.selectsMenuOption("T");
        String expectedOutput  = "Select a valid option!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void exitsIfChoiceIsTwo() {
        biblioteca.selectsMenuOption("3");
        String expectedOutput  = "Goodbye!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void checkedOutBookIsRemovedFromBooks() {
        String input = "The Great Gatsby";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.checkOut();
        biblioteca.listBooks();
        assertThat(outContent.toString(), not(containsString("The Great Gatsby | F. Scott Fitzgerald | 1925")));
    }

    @Test
    public void successMessageWhenUserChecksOutBook() {
        String input = "The Great Gatsby";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.checkOut();
        String expectedOutput  = "Thank you! Enjoy the book\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfUnsuccessfullCheckOut() {
        String input = "The Great Gasby";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.checkOut();
        String expectedOutput  = "That book is not available\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

}
