package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.exceptions.InvalidInputException;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.regions.Regions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StandardMenu extends CommandPromptMenu implements IMenu {
    @Override
    public void displayMenu() {
        Main.getOutput().displayOutput("League of Legends simulator");
        Main.getOutput().displayOutput("Access Level: Standard");
        Main.getOutput().displayOutput("1. New Match");
        Main.getOutput().displayOutput("2. View Players Stats");
        Main.getOutput().displayOutput("3. View Champion Win Rates");
        Main.getOutput().displayOutput("4. View Player Match History");
        Main.getOutput().displayOutput("5. Switch Region");
        Main.getOutput().displayOutput("6. Switch Access Level");
        Main.getOutput().displayOutput("7. Exit Program");
    }

    @Override
    public int getUserChoice() {
        Scanner input = Main.getInputScanner();
        try {
            int userChoice = input.nextInt();
            IIsValidInput checker = (choice) -> choice >= 1 && choice <= 7;
            if (!checker.isValidInput(userChoice)) {
                Main.getOutput().displayOutput("Invalid selection");
                return -1;
            }
            return userChoice;
        } catch (InputMismatchException e) {
            input.nextLine(); // clear input
            Main.getOutput().displayOutput("Invalid input");
            return -1;
        }
    }

    @Override
    public void performUserChoice(int userChoice, Regions regions) {
        Scanner input = Main.getInputScanner();
        switch (userChoice) {
            case 1:
                MatchMaking.matchMake(regions.getCurrentRegion());
                break;
            case 2:
                regions.getCurrentRegion().getPlayerStats().displayStats();
                break;
            case 3:
                regions.getCurrentRegion().getChampionStats().displayStats();
                break;
            case 4:
                getPlayerMatchHistory(regions.getCurrentRegion());
                break;
            case 5:
                switchRegion(regions);
                break;
            case 6:
                switchAccessLevel();
                break;
            case 7:
                Main.getOutput().displayOutput("Exiting");
                input.close();
                System.exit(0);
            default:
                throw new InvalidInputException("Invalid menu selection");
        }
    }
}
