package com.twu.biblioteca;

/**
 * Created by jessastbury on 19/02/2017.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private boolean available = true;

    Book(String bookTitle, String bookAuthor, int bookYear) {
        title = bookTitle;
        author = bookAuthor;
        year = bookYear;
    }

    public String detailsAsString() {
        return title + " | " + author + " | " + year;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isMatchingTitle(String titleGiven) {
        return title.equals(titleGiven);
    }

    public void markAsUnavailable() {
        available = false;
    }

    public void markAsAvailable() {
        available = true;
    }

}
