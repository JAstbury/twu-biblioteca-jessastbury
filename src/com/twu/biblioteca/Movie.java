package com.twu.biblioteca;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class Movie extends LibraryItem {

    private String director;
    private int year;
    private Integer rating;

    Movie(String title, int y, String d, Integer r) {
        super(title);
        year = y;
        director = d;
        rating = r;
    }

    public String detailsAsString() {
        return getTitle() + " | " + year + " | " + director + " | " + rating;
    }
}
