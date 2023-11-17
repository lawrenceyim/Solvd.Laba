package com.solvd.teamgamematch;

import com.solvd.teamgamematch.exceptions.ConfigurationException;
import com.solvd.teamgamematch.menu.CommandPromptMenu;
import com.solvd.teamgamematch.menu.IMenu;
import com.solvd.teamgamematch.output.CommandPromptOutput;
import com.solvd.teamgamematch.output.IOutput;
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
    private static IOutput output;

    public static void main(String[] args) {
        output = new CommandPromptOutput();
        IMenu menu = new CommandPromptMenu();
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
}
