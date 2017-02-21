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
            System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear());
        }
    }

    void checkOut(String title) {
        if (checkForBook(title)) {
            System.out.println("Thank you! Enjoy the book");
            removeBook(title);
        } else {
            System.out.println("That book is not available");
        }
    }

    private boolean checkForBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title))
                return true;
        }
        return false;
    }

    private void removeBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title))
                books.remove(b);
            break;
        }
    }

}
