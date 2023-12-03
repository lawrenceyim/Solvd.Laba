package com.solvd.teamgamematch;

import com.solvd.teamgamematch.employees.EmployeeManager;
import com.solvd.teamgamematch.exceptions.ConfigurationException;
import com.solvd.teamgamematch.exceptions.InvalidAccessLevel;
import com.solvd.teamgamematch.menu.AdministratorMenu;
import com.solvd.teamgamematch.menu.GuestMenu;
import com.solvd.teamgamematch.menu.IMenu;
import com.solvd.teamgamematch.menu.StandardMenu;
import com.solvd.teamgamematch.output.CommandPromptOutput;
import com.solvd.teamgamematch.output.IOutput;
import com.solvd.teamgamematch.person.AccessLevel;
import com.solvd.teamgamematch.regions.Regions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Main method for the League of Legends match predictor
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class Main {
    static {
        File file = new File("src/main/resources/log4j2.xml");
        if (!file.exists()) {
            throw new ConfigurationException("Missing log4j2.xml file");
        }
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Scanner input = new Scanner(System.in);
    private static final Regions regions = new Regions();
    private static final EmployeeManager employeeManager = new EmployeeManager();
    private static IMenu menu;
    private static IOutput output;
    private static AccessLevel currentAccessLevel = AccessLevel.Guest;

    public static void main(String[] args) {
        try {
            output = (IOutput) Class.forName("com.solvd.teamgamematch.output.CommandPromptOutput")
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        setAccessLevel(AccessLevel.Guest);
        setMenu();
        while (true) {
            menu.displayMenu();
            int userChoice = menu.getUserChoice();
            if (userChoice == -1) {
                continue;
            }
            menu.performUserChoice(userChoice, regions);
        }
    }

    public static IOutput getOutput() {
        if (output == null) {
            output = new CommandPromptOutput();
        }
        return output;
    }

    public static EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public static Scanner getInputScanner() {
        return input;
    }

    public static void setAccessLevel(AccessLevel accessLevel) {
        currentAccessLevel = accessLevel;
    }

    public static void setMenu() {
        switch (currentAccessLevel) {
            case Guest:
                menu = new GuestMenu();
                break;
            case Standard:
                menu = new StandardMenu();
                break;
            case Administrator:
                menu = new AdministratorMenu();
                break;
            default:
                throw new InvalidAccessLevel("Invalid access level provided when changing menu");
        }
    }
}
