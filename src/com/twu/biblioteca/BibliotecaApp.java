package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private boolean shouldExit = false;
    Library l = new Library();

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

    void selectsMenuOption(String choice) {
        if (choice.equals("1")) {
            l.listBooks();
        } else if (choice.equals("2")) {
            System.out.println("What is the title of the book you'd like to check out?");
            String bookTitle = getUserChoice();
            l.checkOut(bookTitle);
        } else if (choice.equals("3")) {
            System.out.println("Goodbye!");
            shouldExit = true;
        } else {
            System.out.println("Select a valid option!");
        }
    }

}
