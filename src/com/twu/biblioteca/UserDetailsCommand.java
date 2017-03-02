package com.twu.biblioteca;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class UserDetailsCommand implements Command {
    private User currentUser;
    UserDatabase database = new UserDatabase();

    UserDetailsCommand(User user, UserDatabase database) {
        this.currentUser = user;
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
