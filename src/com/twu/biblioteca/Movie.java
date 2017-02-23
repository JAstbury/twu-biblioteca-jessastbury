package com.twu.biblioteca;

/**
 * Created by jessastbury on 23/02/2017.
 */
public class Movie {

    private String title;
    private String director;
    private int year;
    private Integer rating;

    Movie(String t, int y, String d, Integer r) {
        title = t;
        year = y;
        director = d;
        rating = r;
    }

    public String detailsAsString() {
        return title + " | " + year + " | " + director + " | " + rating;
    }
}
