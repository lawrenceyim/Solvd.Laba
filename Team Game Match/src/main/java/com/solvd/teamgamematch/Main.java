package com.solvd.teamgamematch;

import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.menu.CommandPromptMenu;
import com.solvd.teamgamematch.menu.IMenu;
import com.solvd.teamgamematch.output.CommandPromptOutput;
import com.solvd.teamgamematch.output.IOutput;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.Regions;

import java.awt.*;
import java.util.Scanner;

/**
 * Main method for the League of Legends match predictor
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Main {
    private static IOutput output;

    public static void main(String[] args) {
        output = new CommandPromptOutput();
        final Regions regions = new Regions();
        Scanner input = new Scanner(System.in);
        IMenu menu = new CommandPromptMenu();
        while(true) {
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
