package com.solvd.teamgamematch;

import com.solvd.teamgamematch.menu.CommandPromptMenu;
import com.solvd.teamgamematch.menu.IMenu;
import com.solvd.teamgamematch.output.CommandPromptOutput;
import com.solvd.teamgamematch.output.IOutput;
import com.solvd.teamgamematch.regions.Regions;

/**
 * Main method for the League of Legends match predictor
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static IOutput output;
    private static final Regions regions = new Regions();

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
}
