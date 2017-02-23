package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class UserTest {

    User u;

    @Before
    public void init() {
        u = new User("462-9830", "password123", "Bob", "BobBobbity123@gmail.com", "07976504329");
    }

    @Test
    public void getDetails() {
        assertEquals("Bob | BobBobbity123@gmail.com | 07976504329", u.getDetails());
    }

}
