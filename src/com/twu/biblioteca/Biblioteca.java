package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jessastbury on 02/03/2017.
 */
public class Biblioteca {

    public boolean shouldExit = false;
    public User currentUser = null;
    Library l = new Library();
    UserDatabase database = new UserDatabase();
    private enum Commands { OPTION1, OPTION2, OPTION3, OPTION4, OPTION5, OPTION6, OPTION7 };
    private static final Map<String, Command> commandMap = new HashMap<String, Command>();

    void go() {
        welcomeMessage();
        while (shouldExit == false) {
            giveMenuOptions();
        }
    }

    public void exitApp() {
        shouldExit = true;
    }

    private void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    private void giveMenuOptions() {
        printMenu();
        setUpCommands();
        executeCommand(getUserChoice());
    }

    private void executeCommand(String s) {
        String commandName = "OPTION" + s;
        try {
            Commands.valueOf(commandName);
        } catch (IllegalArgumentException ila) {
            System.out.println("Select a valid option!");
            return;
        }
        Command command = commandMap.get(commandName);
        command.execute();
    }

    private void printMenu() {
        System.out.println("Please choose from these options:\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Check Out Item\n" +
                "4. Return Item\n" +
                "5. Log in\n" +
                "6. View your details\n" +
                "7. Exit");
    }

    private void setUpCommands() {
        commandMap.put("OPTION1", new ListBooksCommand(l));
        commandMap.put("OPTION2", new ListMoviesCommand(l));
        commandMap.put("OPTION3", new CheckOutCommand(l, currentUser));
        commandMap.put("OPTION4", new ReturnCommand(l, currentUser));
        commandMap.put("OPTION5", new LogInCommand(this, database));
        commandMap.put("OPTION6", new UserDetailsCommand(currentUser, database));
        commandMap.put("OPTION7", new ExitCommand(this));
    }

    private String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.nextLine();
    }
}
