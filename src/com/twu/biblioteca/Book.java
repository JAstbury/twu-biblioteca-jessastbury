package com.twu.biblioteca;

/**
 * Created by jessastbury on 19/02/2017.
 */
public class Book extends LibraryItem {
    private String author;
    private int year;

    Book(String title, String bookAuthor, int bookYear) {
        super(title);
        author = bookAuthor;
        year = bookYear;
    }

    public String detailsAsString() {
        return getTitle() + " | " + author + " | " + year;
    }

}
