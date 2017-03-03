package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.CoreMatchers.containsString;

public class BibliotecaTest {

    Biblioteca biblioteca;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        biblioteca = new Biblioteca();
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        biblioteca.welcomeMessage();
        String expectedOutput  = "Hello, welcome to Biblioteca!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void exitAppStopsLoopingTheMenu() {
        biblioteca.exitApp();
        String expectedOutput  = "Please choose from these options:\n";
        assertThat(outContent.toString(), not(containsString(expectedOutput)));
    }

    @Test
    public void displaysWelcomeMessage() {
        String input = "9";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput  = "Please choose from these options:\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void displaysMenu() {
        String input = "9";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput  = "Please choose from these options:\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Check Out Item\n" +
                "4. Return Item\n" +
                "5. Log in\n" +
                "6. View your details\n" +
                "7. Exit";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void userNotifiedOfInvalidChoice() {
        String input = "9";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput  = "Select a valid option!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void listBooksIfUserPicksOne() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput  = "The Great Gatsby | F. Scott Fitzgerald | 1925\n" +
                "Moby Dick | Herman Melville | 1851\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void listMoviesIfUserPicksOne() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput  = "Pulp Fiction | 1994 | Quentin Tarantino | 9\n" +
                "Inception | 2010 | Christopher Nolan | 8\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }


    @Test
    public void exitsIfChoiceIsSeven() {
        String input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        biblioteca.giveMenuOptions();
        String expectedOutput = "Goodbye!\n";
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void asksUserToLogInBeforeCheckOut() {
        String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String expectedOutput = "Please log in.\n";
        biblioteca.giveMenuOptions();
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Before
    public void signsUserIn() {
        biblioteca.currentUser = new User("462-9830", "password123", "Bob", "BobBobbity123@gmail.com", "07976504329");
    }

    @Test
    public void returnsUserDetails() {
        String input = "6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String expectedOutput = "Bob | BobBobbity123@gmail.com | 07976504329\n";
        biblioteca.giveMenuOptions();
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

}
