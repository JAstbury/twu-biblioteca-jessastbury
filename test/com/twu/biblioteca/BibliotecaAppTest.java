package com.twu.biblioteca;


import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BibliotecaAppTest {

    BibliotecaApp biblioteca;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void welcomeMessage() {
        biblioteca.welcomeMessage();
        String expectedOutput  = "Hello, welcome to Biblioteca!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void listBooks() {
        biblioteca.listBooks();
        String expectedOutput  = "The Great Gatsby\nMoby Dick\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
