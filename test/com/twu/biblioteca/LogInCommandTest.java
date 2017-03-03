package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class LogInCommandTest {
    LogInCommand logInCommand;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        Biblioteca biblioteca = new Biblioteca();
        UserDatabase database = new UserDatabase();
        logInCommand = new LogInCommand(biblioteca, database);
    }

    @Test
    public void printsSuccessMessageIfSuccessfulLogIn () {
        String simulatedUserInput = "462-9830" + System.getProperty("line.separator")
                + "password123" + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        logInCommand.execute();

        System.setIn(savedStandardInputStream);
        String expectedOutput  = "Please enter your username:\n" +
                "Please enter your password:\n" +
                "Log in successful\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printsSuccessMessageIfLogInFails () {
        String userInput = "462-9830" + System.getProperty("line.separator")
                + "password153" + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        logInCommand.execute();

        System.setIn(savedStandardInputStream);
        String expectedOutput  = "Please enter your username:\n" +
                "Please enter your password:\n" +
                "Log in unsuccessful\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
