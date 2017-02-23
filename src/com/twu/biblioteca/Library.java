package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessastbury on 21/02/2017.
 */
public class Library {
    private ArrayList<LibraryItem> items = new ArrayList<LibraryItem>();

    Library() {
        items.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        items.add(new Book("Moby Dick", "Herman Melville", 1851));
        items.add(new Movie("Pulp Fiction", 1994, "Quentin Tarantino",9));
        items.add(new Movie("Inception", 2010, "Christopher Nolan", 8));
    }

    void printAvailableItems(ArrayList<LibraryItem> itemsToPrint) {
        for (LibraryItem i : itemsToPrint) {
            if (i.isAvailable())
                System.out.println(i.detailsAsString());
        }
    }

    void listMovies() {
        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        for (LibraryItem i : items) {
            if (i instanceof Movie) {
                movies.add(i);
            }
        }
        printAvailableItems(movies);
    }

    void listBooks() {
        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        for (LibraryItem i : items) {
            if (i instanceof Book) {
                books.add(i);
            }
        }
        printAvailableItems(books);
    }

    void checkOut(String title) {
        if (validCheckOut(title)) {
            System.out.println("Thank you! Enjoy.");
        } else {
            System.out.println("That item is not available");
        }
    }

    void returnBook(String title) {
        if (validReturn(title)) {
            System.out.println("Thank you for returning the item.");
        } else {
            System.out.println("That is not a valid item to return.");
        }
    }

    private boolean validCheckOut(String title) {
        for (LibraryItem i : items) {
            if (i.isMatchingTitle(title) && i.isAvailable()) {
                i.markAsUnavailable();
                return true;
            }
        }
        return false;
    }

    private boolean validReturn(String title) {
        for (LibraryItem i : items) {
            if (i.isMatchingTitle(title) && !i.isAvailable()) {
                i.markAsAvailable();
                return true;
            }
        }
        return false;
    }

}
