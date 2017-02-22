package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by jessastbury on 21/02/2017.
 */
public class LibraryTest {
    Library l;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        l = new Library();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void listBooks() {
        l.listBooks();
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void checkedOutBookIsRemovedFromAvailableBooks() {
        l.checkOut("Moby Dick");
        l.listBooks();
        assertThat(outContent.toString(), not(containsString("Moby Dick | Herman Melville | 1851")));
    }

    @Test
    public void successMessageWhenUserChecksOutBook() {
        l.checkOut("Moby Dick");
        String expectedOutput  = "Thank you! Enjoy the book\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfUnsuccessfullCheckOut() {
        l.checkOut("The Great Gasby");
        String expectedOutput  = "That book is not available\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void ReturnedBookIsMarkedAsAvailable() {
        l.checkOut("Moby Dick");
        l.returnBook("Moby Dick");
        l.listBooks();
        assertThat(outContent.toString(), containsString("Moby Dick | Herman Melville | 1851"));
    }

    @Test
    public void successMessageWhenUserReturnsBook() {
        l.checkOut("Moby Dick");
        l.returnBook("Moby Dick");
        String expectedOutput  = "Thank you for returning the book.\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfUnsuccessfullReturn() {
        l.checkOut("The Great Gatsby");
        l.returnBook("The Great Gasby");
        String expectedOutput  = "That is not a valid book to return.\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

}
