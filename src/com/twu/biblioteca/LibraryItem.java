package com.twu.biblioteca;

/**
 * Created by jessastbury on 23/02/2017.
 */
abstract public class LibraryItem {

    private String title;
    private boolean checkedIn = true;

    LibraryItem(String t) {
        title = t;
    }

    public abstract String detailsAsString();

    public String getTitle() {
        return title;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void markAsCheckedIn() {
        checkedIn = true;
    }

    public void markAsCheckedOut() {
        checkedIn = false;
    }

}
