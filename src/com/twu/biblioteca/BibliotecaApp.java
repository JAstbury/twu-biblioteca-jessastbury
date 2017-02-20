package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private ArrayList<Book> books = new ArrayList<Book>();

    BibliotecaApp() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
    }

    public static void main(String[] args) {
        BibliotecaApp b = new BibliotecaApp();
        b.welcomeMessage();
        b.menuDisplay();
    }

    void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n1. List Books");
    }

    void menuDisplay() {
        System.out.println("Please choose from these options:");
        getUserChoice();
    }

    String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.next( );
    }

    void listBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear());
        }
    }

}
