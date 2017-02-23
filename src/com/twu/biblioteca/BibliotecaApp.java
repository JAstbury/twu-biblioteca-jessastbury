package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private boolean shouldExit = false;
    Library l = new Library();

    public static void main(String[] args) {
        new BibliotecaApp().go();
    }

    void go() {
        welcomeMessage();
        while (shouldExit == false) {
            giveMenuOptions();
        }
    }

    void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    void giveMenuOptions() {
        printMenu();
        String choice = getUserChoice();
        selectsMenuOption(choice);
    }

    String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.nextLine();
    }

    void selectsMenuOption(String choice) {
        if (choice.equals("1"))
            l.listBooks();
        else if (choice.equals("2"))
            l.listMovies();
        else if (choice.equals("3"))
            bookCheckOut();
        else if (choice.equals("4"))
            bookReturn();
        else if (choice.equals("5"))
            exitProgram();
        else
            System.out.println("Select a valid option!");
    }

    private void printMenu() {
        System.out.println("Please choose from these options:\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Check Out Item\n" +
                "4. Return Item\n" +
                "5. Exit");
    }

    private void bookCheckOut() {
        System.out.println("What is the title of the book you'd like to check out?");
        String title = getUserChoice();
        l.checkOut(title);
    }

    private void bookReturn() {
        System.out.println("What is the title of the book you'd like to return?");
        String title = getUserChoice();
        l.returnBook(title);
    }

    private void exitProgram() {
        System.out.println("Goodbye!");
        shouldExit = true;
    }
}
