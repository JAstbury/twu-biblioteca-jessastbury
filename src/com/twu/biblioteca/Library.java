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
                System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear());
        }
    }

    void checkOut(String title) {
        if (canBeCheckedOut(title)) {
            System.out.println("Thank you! Enjoy the book");
            processCheckOut(title);
        } else {
            System.out.println("That book is not available");
        }
    }

    void returnBook(String title) {
        if (canBeReturned(title)) {
            System.out.println("Thank you for returning the book.");
            processReturn(title);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private boolean canBeCheckedOut(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.isAvailable())
                return true;
        }
        return false;
    }

    private boolean canBeReturned(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.isAvailable())
            return true;
        }
        return false;
    }

    private void processCheckOut(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                b.markAsUnavailable();
            }
        }
    }

    private void processReturn(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title))
                b.markAsAvailable();
        }
    }

}
