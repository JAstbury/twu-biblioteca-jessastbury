package com.twu.biblioteca;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class ExitCommand implements Command {
    Biblioteca biblioteca;

    ExitCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void execute() {
        System.out.println("Goodbye!");
        biblioteca.exitApp();
    }
}
