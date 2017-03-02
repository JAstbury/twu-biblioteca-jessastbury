package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ReturnCommand implements Command {
    private Library library;
    private User currentUser;

    ReturnCommand(Library library, User user) {
        this.library = library;
        this.currentUser = user;
    }

    public void execute() {
        if (isLoggedIn()) {
            System.out.println("What is the title of the item you'd like to return?");
            String title = getUserChoice();
            library.returnItem(title);
        } else {
            System.out.println("Please log in.");
        }
    }

    private boolean isLoggedIn() {
        return currentUser != null;
    }

    private String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.nextLine();
    }
}
