package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessastbury on 21/02/2017.
 */
public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    Library() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
    }

    void listBooks() {
        for (Book b : books) {
            if (b.isAvailable())
                System.out.println(b.detailsAsString());
        }
    }

    void checkOut(String title) {
        if (validCheckOut(title)) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available");
        }
    }

    void returnBook(String title) {
        if (validReturn(title)) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private boolean validCheckOut(String title) {
        for (Book b : books) {
            if (b.isMatchingTitle(title) && b.isAvailable()) {
                b.markAsUnavailable();
                return true;
            }
        }
        return false;
    }

    private boolean validReturn(String title) {
        for (Book b : books) {
            if (b.isMatchingTitle(title) && !b.isAvailable()) {
                b.markAsAvailable();
                return true;
            }
        }
        return false;
    }

}
