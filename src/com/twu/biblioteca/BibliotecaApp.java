package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private ArrayList<Book> books = new ArrayList<Book>();
    private boolean shouldExit = false;

    BibliotecaApp() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
    }

    public static void main(String[] args) {
        BibliotecaApp b = new BibliotecaApp();
        b.go();
    }

    void go() {
        welcomeMessage();
        while (shouldExit == false) {
            menuDisplay();
        }
    }


    void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    void menuDisplay() {
            System.out.println("Please choose from these options:\n1. List Books\n2. Exit");
            String choice = getUserChoice();
            selectsMenuOption(choice);
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

    void selectsMenuOption(String choice) {
        if (choice.equals("1")) {
            listBooks();
        } else if (choice.equals("2")) {
            System.out.println("Goodbye!");
            shouldExit = true;
        } else {
            System.out.println("Select a valid option!");
        }
    }

}
