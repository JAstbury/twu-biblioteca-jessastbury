package com.twu.biblioteca;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ListMoviesCommand implements Command {

    private Library library;

    ListMoviesCommand(Library library) {
        this.library = library;
    }

    public void execute() {
        library.listItems(Movie.class);
    }
}
