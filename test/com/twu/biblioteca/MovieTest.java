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
        assertEquals(true, m.isCheckedIn());
    }

    @Test
    public void markAsUnavailable() {
        m.markAsCheckedOut();
        assertEquals(false, m.isCheckedIn());
    }

    @Test
    public void markAsAvailable() {
        m.markAsCheckedOut();
        m.markAsCheckedIn();
        assertEquals(true, m.isCheckedIn());
    }

}
