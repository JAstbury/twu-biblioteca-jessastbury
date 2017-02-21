package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jessastbury on 21/02/2017.
 */
public class Library {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();
    private ArrayList<Book> unavailableBooks = new ArrayList<Book>();

    Library() {
        availableBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        availableBooks.add(new Book("Moby Dick", "Herman Melville", 1851));
    }

    void listBooks() {
        for (Book b : availableBooks) {
            System.out.println(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear());
        }
    }

    void checkOut(String title) {
        if (checkForBook(title, availableBooks)) {
            System.out.println("Thank you! Enjoy the book");
            moveBookToUnavailable(title);
        } else {
            System.out.println("That book is not available");
        }
    }

    void returnBook(String title) {
        if (checkForBook(title, unavailableBooks)) {
            System.out.println("Thank you for returning the book.");
            moveBookToAvailable(title);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private boolean checkForBook(String title, ArrayList<Book> list) {
        for (Book b : list) {
            if (b.getTitle().equals(title))
                return true;
        }
        return false;
    }

    private void moveBookToUnavailable(String title) {
        for (Book b : availableBooks) {
            if (b.getTitle().equals(title))
                availableBooks.remove(b);
                unavailableBooks.add(b);
            break;
        }
    }

    private void moveBookToAvailable(String title) {
        for (Book b : unavailableBooks) {
            if (b.getTitle().equals(title))
                unavailableBooks.remove(b);
                availableBooks.add(b);
            break;
        }
    }

}
