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
public class CheckOutCommandTest {
    Library spyLibrary;
    CheckOutCommand checkOutCommandNoUser;
    CheckOutCommand checkOutCommandUser;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        User user = null;
        Library library = mock(Library.class);
        checkOutCommandNoUser = new CheckOutCommand(library, user);
        spyLibrary = spy(new Library());
        User user2 = mock(User.class);
        checkOutCommandUser = new CheckOutCommand(spyLibrary, user2);
    }

    @Test
    public void asksUserToLogInIfNoCurrentUser () {
        checkOutCommandNoUser.execute();
        String expectedOutput  = "Please log in.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void asksLibraryToCheckOutIfCurrentUser () {
        String input = "Moby Dick";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        checkOutCommandUser.execute();
        verify(spyLibrary, times(1)).checkOutItem("Moby Dick");
    }

}
