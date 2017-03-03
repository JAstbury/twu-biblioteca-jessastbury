package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class LogInCommand implements Command {
    private UserDatabase database;
    private User currentUser;
    Biblioteca b;

    LogInCommand(Biblioteca b, UserDatabase database) {
        this.b = b;
        this.currentUser = b.currentUser;
        this.database = database;
    }

    public void execute() {
        Scanner user_input = new Scanner( System.in );
        System.out.println("Please enter your username:");
        String username = user_input.nextLine();;
        System.out.println("Please enter your password:");
        String password = user_input.nextLine();
        checkInput(username, password);
    }

    public void checkInput(String username, String password) {
        b.currentUser = database.checkCredentials(username, password);
        if (b.currentUser == null) {
            System.out.println("Log in unsuccessful");
        } else {
            System.out.println("Log in successful");
        }
    }

}
