package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class UserDatabase {
    private ArrayList<User> users = new ArrayList<User>();

    UserDatabase() {
        users.add(new User("462-9830", "password123", "Bob", "BobBobbity123@gmail.com", "07976504329"));
        users.add(new User("892-5610", "password456", "Kate", "KateyCat78@gmail.com", "07956428902"));
    }

    public User checkCredentials(String username, String password) {
        for (User u : users) {
            if (u.isMatchingUsername(username) && u.isMatchingPassword(password)) {
                return u;
            }
        }
        return null;
    }

    public void printUserDetails(User u) {
        System.out.println(u.getDetails());
    }
}
