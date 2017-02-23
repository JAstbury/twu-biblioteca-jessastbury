package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class MovieTest {
    Movie m;

    @Before
    public void init() {
        m = new Movie("Pulp Fiction", 1994, "Quentin Tarantino", 9);
    }

    @Test
    public void detailsAsString() {
        assertEquals("Pulp Fiction | 1994 | Quentin Tarantino | 9", m.detailsAsString());
    }

    @Test
    public void startsAsAvailable() {
        assertEquals(true, m.isAvailable());
    }

    @Test
    public void markAsUnavailable() {
        m.markAsUnavailable();
        assertEquals(false, m.isAvailable());
    }

    @Test
    public void markAsAvailable() {
        m.markAsUnavailable();
        m.markAsAvailable();
        assertEquals(true, m.isAvailable());
    }

    @Test
    public void returnsTrueIfMatchingTitle() {
        assertEquals(true, m.isMatchingTitle("Pulp Fiction"));
    }

    @Test
    public void returnsFalseIfNotMatchingTitle() {
        assertEquals(false, m.isMatchingTitle("Moby Dick"));
    }

}
