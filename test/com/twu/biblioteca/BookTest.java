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
    public void detailsAsString() {
        assertEquals("The Great Gatsby | F. Scott Fitzgerald | 1925", b.detailsAsString());
    }

    @Test
    public void startsAsAvailable() {
        assertEquals(true, b.isCheckedIn());
    }

    @Test
    public void markAsUnavailable() {
        b.markAsCheckedOut();
        assertEquals(false, b.isCheckedIn());
    }

    @Test
    public void markAsAvailable() {
        b.markAsCheckedOut();
        b.markAsCheckedIn();
        assertEquals(true, b.isCheckedIn());
    }

}
