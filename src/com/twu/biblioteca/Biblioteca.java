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
    Library library = new Library();
    UserDatabase database = new UserDatabase();

    private enum Commands { OPTION1, OPTION2, OPTION3, OPTION4, OPTION5, OPTION6, OPTION7 };
    private static final Map<String, Command> commandMap = new HashMap<String, Command>();

    public void welcomeMessage() {
        System.out.println("Hello, welcome to Biblioteca!\n");
    }

    public void showMenu() {
        while (shouldExit == false) {
            giveMenuOptions();
        }
    }

    public void exitApp() {
        shouldExit = true;
    }

    public void giveMenuOptions() {
        printMenu();
        setUpCommands();
        String choice = getUserChoice();
        executeCommand(choice);
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
        commandMap.put("OPTION1", new ListBooksCommand(library));
        commandMap.put("OPTION2", new ListMoviesCommand(library));
        commandMap.put("OPTION3", new CheckOutCommand(library, currentUser));
        commandMap.put("OPTION4", new ReturnCommand(library, currentUser));
        commandMap.put("OPTION5", new LogInCommand(this, database));
        commandMap.put("OPTION6", new UserDetailsCommand(currentUser, database));
        commandMap.put("OPTION7", new ExitCommand(this));
    }

    public String getUserChoice() {
        Scanner user_input = new Scanner( System.in );
        return user_input.nextLine();
    }
}
