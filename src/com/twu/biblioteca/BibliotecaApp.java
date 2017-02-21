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
        System.out.println("Please choose from these options:\n1. List Books\n2. Check Out Book\n3. Exit");
        String choice = getUserChoice();
        selectsMenuOption(choice);
    }

    String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.nextLine();
    }

    void listBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear());
        }
    }

    void checkOut() {
        System.out.println("What is the title of the book you'd like to check out?");
        String bookTitle = getUserChoice();
        if (checkForBook(bookTitle)) {
            System.out.println("Thank you! Enjoy the book");
            removeBook(bookTitle);
        } else {
            System.out.println("That book is not available");
        }
    }

    boolean checkForBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title))
                return true;
        }
        return false;
    }

    void removeBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title))
                books.remove(b);
                break;
        }
    }

    void selectsMenuOption(String choice) {
        if (choice.equals("1")) {
            listBooks();
        } else if (choice.equals("2")) {
            checkOut();
        } else if (choice.equals("3")) {
            System.out.println("Goodbye!");
            shouldExit = true;
        } else {
            System.out.println("Select a valid option!");
        }
    }

}
