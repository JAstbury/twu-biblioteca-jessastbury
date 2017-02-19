package com.twu.biblioteca;

/**
 * Created by jessastbury on 19/02/2017.
 */
public class Book {
    String title;
    String author;
    int year;

    public Book(String bookTitle, String bookAuthor, int bookYear) {
        title = bookTitle;
        author = bookAuthor;
        year = bookYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
