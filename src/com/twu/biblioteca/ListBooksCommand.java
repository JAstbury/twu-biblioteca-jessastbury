package com.twu.biblioteca;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ListBooksCommand implements Command {

    private Library library;

    ListBooksCommand(Library library) {
        this.library = library;
    }

    public void execute() {
        library.listItems(Book.class);
    }

}
