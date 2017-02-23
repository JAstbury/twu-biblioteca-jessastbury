package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private boolean shouldExit = false;
    private User currentUser = null;
    Library l = new Library();
    UserDatabase database = new UserDatabase();

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
            l.listItems(Book.class);
        else if (choice.equals("2"))
            l.listItems(Movie.class);
        else if (choice.equals("3"))
            startCheckOut();
        else if (choice.equals("4"))
            startReturn();
        else if (choice.equals("5"))
            getLogInDetails();
        else if (choice.equals("6"))
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
                "5. Log in\n" +
                "6. Exit");
    }

    private void startCheckOut() {
        if (isLoggedIn()) {
            System.out.println("What is the title of the item you'd like to check out?");
            String title = getUserChoice();
            l.checkOutItem(title);
        } else {
            System.out.println("Please log in.");
        }
    }

    private void startReturn() {
        if (isLoggedIn()) {
            System.out.println("What is the title of the item you'd like to return?");
            String title = getUserChoice();
            l.returnItem(title);
        } else {
            System.out.println("Please log in.");
        }
    }

    private void exitProgram() {
        System.out.println("Goodbye!");
        shouldExit = true;
    }

    private boolean isLoggedIn() {
        return currentUser != null;
    }

    private void getLogInDetails() {
        System.out.println("Please enter your username:");
        String username = getUserChoice();
        System.out.println("Please enter your password:");
        String password = getUserChoice();
        checkInput(username, password);
    }

    private void checkInput(String username, String password) {
        currentUser = database.checkCredentials(username, password);
        if (currentUser == null) {
            System.out.println("Log in unsuccessful");
        } else {
            System.out.println("Log in successful");
        }
    }
}
