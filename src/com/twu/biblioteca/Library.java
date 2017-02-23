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
        if (canBeProcessed(title, true)) {
            System.out.println("Thank you! Enjoy the book");
            processCheckOut(title);
        } else {
            System.out.println("That book is not available");
        }
    }

    void returnBook(String title) {
        if (canBeProcessed(title, false)) {
            System.out.println("Thank you for returning the book.");
            processReturn(title);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private boolean canBeProcessed(String title, boolean forCheckOut) {
        for (Book b : books) {
            if (b.isMatchingTitle(title) && b.isAvailable() == forCheckOut)
                return true;
        }
        return false;
    }

    private void processCheckOut(String title) {
        for (Book b : books) {
            if (b.isMatchingTitle(title)) {
                b.markAsUnavailable();
            }
        }
    }

    private void processReturn(String title) {
        for (Book b : books) {
            if (b.isMatchingTitle(title))
                b.markAsAvailable();
        }
    }

}
