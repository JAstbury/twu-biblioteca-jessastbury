package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class UserDetailsCommandTest {
    UserDetailsCommand userDetailsNoUser;
    UserDetailsCommand userDetailsUser;
    UserDatabase database;
    User user2;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        User user = null;
        database = mock(UserDatabase.class);
        userDetailsNoUser = new UserDetailsCommand(user, database);
        user2 = mock(User.class);
        userDetailsUser = new UserDetailsCommand(user2, database);
    }

    @Test
    public void asksUserToLogInIfNoCurrentUser () {
        userDetailsNoUser.execute();
        String expectedOutput  = "Please log in.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void returnsUserDetailsIfCurrentUser () {
        userDetailsUser.execute();
        verify(database, times(1)).printUserDetails(user2);
    }
}
