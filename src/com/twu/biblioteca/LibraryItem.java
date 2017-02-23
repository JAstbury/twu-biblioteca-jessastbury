package com.twu.biblioteca;

/**
 * Created by jessastbury on 23/02/2017.
 */
abstract public class LibraryItem {

    private String title;
    private boolean available = true;

    LibraryItem(String t) {
        title = t;
    }

    public abstract String detailsAsString();

    public String getTitle() {
        return title;
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
