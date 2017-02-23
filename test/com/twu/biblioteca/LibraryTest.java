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
        l.listItems(Book.class);
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void listMovies() {
        l.listItems(Movie.class);
        String expectedOutput  = "Pulp Fiction | 1994 | Quentin Tarantino | 9\n" +
                "Inception | 2010 | Christopher Nolan | 8\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void checkedOutBookIsRemovedFromAvailableBooks() {
        l.checkOutItem("Moby Dick");
        l.listItems(Book.class);
        assertThat(outContent.toString(), not(containsString("Moby Dick | Herman Melville | 1851")));
    }

    @Test
    public void successMessageWhenUserChecksOutBook() {
        l.checkOutItem("Moby Dick");
        String expectedOutput  = "Thank you! Enjoy.\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfUnsuccessfullCheckOut() {
        l.checkOutItem("The Great Gasby");
        String expectedOutput  = "That item is not available\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void ReturnedBookIsMarkedAsAvailable() {
        l.checkOutItem("Moby Dick");
        l.returnItem("Moby Dick");
        l.listItems(Book.class);
        assertThat(outContent.toString(), containsString("Moby Dick | Herman Melville | 1851"));
    }

    @Test
    public void successMessageWhenUserReturnsBook() {
        l.checkOutItem("Moby Dick");
        l.returnItem("Moby Dick");
        String expectedOutput  = "Thank you for returning the item.\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfUnsuccessfullReturn() {
        l.checkOutItem("The Great Gatsby");
        l.returnItem("The Great Gasby");
        String expectedOutput  = "That is not a valid item to return.\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

}
