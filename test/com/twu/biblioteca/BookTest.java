package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 19/02/2017.
 */
public class BookTest {

    @Test
    public void newBook() {
        Book b = new Book("The Great Gatsby");
        assertEquals("The Great Gatsby", b.getTitle());
    }

}
