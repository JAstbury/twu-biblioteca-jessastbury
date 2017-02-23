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
}
