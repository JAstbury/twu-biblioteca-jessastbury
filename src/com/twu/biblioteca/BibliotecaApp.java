package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    ArrayList<Book> books = new ArrayList<Book>();

    BibliotecaApp() {
        books.add(new Book("The Great Gatsby"));
        books.add(new Book("Moby Dick"));
    }

    public static void main(String[] args) {
        BibliotecaApp b = new BibliotecaApp();
        b.welcomeMessage();
        b.listBooks();
    }

    public void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!");
    }

    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
    }

}
