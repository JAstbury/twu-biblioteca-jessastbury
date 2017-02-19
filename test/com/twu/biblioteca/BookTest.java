package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 19/02/2017.
 */
public class BookTest {
    Book b;

    @Before
    public void init() {
        b = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
    }

    @Test
    public void bookTitle() {
        assertEquals("The Great Gatsby", b.getTitle());
    }

    @Test
    public void bookAuthor() {
        assertEquals("F. Scott Fitzgerald", b.getAuthor());
    }

    @Test
    public void bookYear() {
        assertEquals(1925, b.getYear());
    }

}
