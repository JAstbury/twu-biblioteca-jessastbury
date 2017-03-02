package com.twu.biblioteca;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class UserDetailsCommand implements Command {
    private User currentUser;
    private UserDatabase database;

    UserDetailsCommand(User user, UserDatabase database) {
        this.currentUser = user;
        this.database = database;
    }

    public void execute() {
        if (isLoggedIn()) {
            database.printUserDetails(currentUser);
        } else {
            System.out.println("Please log in.");
        }
    }

    private boolean isLoggedIn() {
        return currentUser != null;
    }

}
