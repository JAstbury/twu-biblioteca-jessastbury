package com.twu.biblioteca;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    User(String u, String pw, String n, String e, String p) {
        username = u;
        password = pw;
        name = n;
        email = e;
        phone = p;
    }

    public String getDetails() {
        return name + " | " + email + " | " + phone;
    }
}
