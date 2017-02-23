package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class UserDatabaseTest {

    UserDatabase database;

    @Before
    public void init() {
        database = new UserDatabase();
    }

    @Test
    public void returnsUserIfCorrectCredentials() {
        User currentUser = database.checkCredentials("462-9830", "password123");
        assertEquals(User.class, currentUser.getClass());
    }

    @Test
    public void returnsNullIfIncorrectCredentials() {
        User currentUser = database.checkCredentials("462-9830", "password173");
        assertEquals(null, currentUser);
    }

}
