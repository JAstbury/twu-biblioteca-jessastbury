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

    @Test
    public void isMatchingUsernameReturnsTrueIfMatch() {
        assertEquals(true, u.isMatchingUsername("462-9830"));
    }

    @Test
    public void isMatchingUsernameReturnsFalseIsNoMatch() {
        assertEquals(false, u.isMatchingUsername("462-9820"));
    }

    @Test
    public void isMatchingPasswordReturnsTrueIfMatch() {
        assertEquals(true, u.isMatchingPassword("password123"));
    }

    @Test
    public void isMatchingPasswordReturnsFalseIsNoMatch() {
        assertEquals(false, u.isMatchingPassword("password126"));
    }
}
