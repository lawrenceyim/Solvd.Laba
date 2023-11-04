package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.Regions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Main menu for the program when displaying output to a command prompt or terminal
 *
 * @version 1.0 4 Nov 2023
 * @author Lawrence Yim
 */


public class CommandPromptMenu implements IMenu {
    private Scanner input;

    public CommandPromptMenu() {
        input = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
            Main.getOutput().displayOutput("League of Legends simulator");
            Main.getOutput().displayOutput("1. New Match");
            Main.getOutput().displayOutput("2. View Players Stats");
            Main.getOutput().displayOutput("3. View Champion Win Rates");
            Main.getOutput().displayOutput("4. View Player Match History");
            Main.getOutput().displayOutput("5. Switch Region");
            Main.getOutput().displayOutput("6. Exit Program");
    }

    @Override
    public int getUserChoice() {
        try {
            int userChoice = input.nextInt();
            if (!isValidChoice(userChoice)) {
                Main.getOutput().displayOutput("Invalid selection");
                return -1;
            }
            return userChoice;
        } catch (Exception e) {
            input.nextLine(); // clear input
            Main.getOutput().displayOutput("Invalid input");
            return -1;
        }
    }

    @Override
    public void performUserChoice(int userChoice, Regions regions) {
        switch (userChoice) {
            case 1:
                MatchMaking.matchMake(regions.getCurrentRegion());
                break;
            case 2:
                regions.getCurrentRegion().getPlayerStats().displayPlayerStats();
                break;
            case 3:
                regions.getCurrentRegion().getChampionStats().displayChampionStats();
                break;
            case 4:
                getPlayerMatchHistory(regions.getCurrentRegion());
                break;
            case 5:
                switchRegion(regions);
                break;
            default:
                Main.getOutput().displayOutput("Exiting");
                input.close();
                System.exit(0);
        }
    }

    @Override
    public void switchRegion(Regions regions) {
        Set<String> set = regions.getRegions().keySet();
        String[] regionNames = set.toArray(new String[set.size()]);
        Main.getOutput().displayOutput("Regions:");
        for (int i = 1; i <= regionNames.length; i++) {
            Main.getOutput().displayOutput(i + ". " + regionNames[i - 1]);
        }
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= regionNames.length) {
                Main.getOutput().displayOutput("Switching regions to " + regionNames[choice - 1]);
                regions.setCurrentRegion(regionNames[choice - 1]);
            }
        } catch(InputMismatchException e) {
            input.nextLine(); // clear input
        }
        Main.getOutput().displayOutput("Invalid region. Returning to main menu");
    }

    private boolean isValidChoice(int choice) {
        return (choice >= 1 && choice <= 6);
    }

    private void getPlayerMatchHistory(Region region) {
        Main.getOutput().displayOutput("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        region.getPlayerMatchHistory().displayPlayerMatchHistory(name);
    }
}
