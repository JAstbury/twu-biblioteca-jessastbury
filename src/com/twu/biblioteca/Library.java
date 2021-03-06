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
            if (i.isCheckedIn())
                System.out.println(i.detailsAsString());
        }
    }

    void listItems(Class itype) {
        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        for (LibraryItem i : items) {
            if (itype.isInstance(i)) {
                movies.add(i);
            }
        }
        printAvailableItems(movies);
    }

    void checkOutItem(String title) {
        if (validCheckOut(title)) {
            System.out.println("Thank you! Enjoy.");
        } else {
            System.out.println("That item is not available");
        }
    }

    void returnItem(String title) {
        if (validReturn(title)) {
            System.out.println("Thank you for returning the item.");
        } else {
            System.out.println("That is not a valid item to return.");
        }
    }

    private boolean validCheckOut(String title) {
        for (LibraryItem i : items) {
            if (isMatchingTitle(i, title) && i.isCheckedIn()) {
                i.markAsCheckedOut();
                return true;
            }
        }
        return false;
    }

    private boolean validReturn(String title) {
        for (LibraryItem i : items) {
            if (isMatchingTitle(i, title) && !i.isCheckedIn()) {
                i.markAsCheckedIn();
                return true;
            }
        }
        return false;
    }

    private boolean isMatchingTitle(LibraryItem i, String titleGiven) {
        return i.getTitle().equals(titleGiven);
    }


}
