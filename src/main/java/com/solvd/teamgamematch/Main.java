package com.solvd.teamgamematch;

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
    private static IMenu menu;
    private static IOutput output;
    private static AccessLevel currentAccessLevel = AccessLevel.Guest;

    public static void main(String[] args) {
        output = new CommandPromptOutput();
        menu = new GuestMenu();
        while (true) {
            menu.displayMenu();
            int userChoice = menu.getUserChoice();
            menu.performUserChoice(userChoice, regions);
        }
    }

    public static IOutput getOutput() {
        if (output == null) {
            output = new CommandPromptOutput();
        }
        return output;
    }

    public static Scanner getInputScanner() {
        return input;
    }

    public static void setAccessLevel(AccessLevel accessLevel) {
        currentAccessLevel = accessLevel;
        switch (accessLevel) {
            case Guest:
                setMenu(new GuestMenu());
                break;
            case Standard:
                setMenu(new StandardMenu());
                break;
            case Administrator:
                setMenu(new AdministratorMenu());
                break;
            default:
                throw new InvalidAccessLevel("Invalid access level provided when changing menu");
        }
    }

    public static void setMenu(IMenu menu) {
        Main.menu = menu;
    }
}
