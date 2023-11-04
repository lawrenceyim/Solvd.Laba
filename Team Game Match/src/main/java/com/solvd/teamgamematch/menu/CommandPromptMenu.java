package com.solvd.teamgamematch.menu;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.Regions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class CommandPromptMenu implements IMenu {
    @Override
    public void menuLoop() {
        final Regions regions = new Regions();
        Region currentRegion = regions.getRegion("NA");

        int userChoice;
        Scanner input = new Scanner(System.in);
        while (true) {
            printMenu(currentRegion.getRegionName());
            try {
                userChoice = input.nextInt();
            } catch (Exception e) {
                input.nextLine(); // clear input
                Main.getOutput().displayOutput("Invalid input");
                continue;
            }
            if (!isValidChoice(userChoice)) {
                Main.getOutput().displayOutput("Invalid selection");
                continue;
            }
            switch (userChoice) {
                case 1:
                    MatchMaking.matchMake(currentRegion);
                    break;
                case 2:
                    currentRegion.getPlayerStats().displayPlayerStats();
                    break;
                case 3:
                    currentRegion.getChampionStats().displayChampionStats();
                    break;
                case 4:
                    getPlayerName(input, currentRegion);
                    break;
                case 5:
                    currentRegion = regions.getRegion(switchRegion(regions, currentRegion.getRegionName(), input));
                    break;
                default:
                    Main.getOutput().displayOutput("Exiting");
                    input.close();
                    System.exit(0);
            }
        }
    }

    public void printMenu(String regionName) {
            Main.getOutput().displayOutput("League of Legends simulator");
            Main.getOutput().displayOutput("Current region: " + regionName);
            Main.getOutput().displayOutput("1. New Match");
            Main.getOutput().displayOutput("2. View Players Stats");
            Main.getOutput().displayOutput("3. View Champion Win Rates");
            Main.getOutput().displayOutput("4. View Player Match History");
            Main.getOutput().displayOutput("5. Switch Region");
            Main.getOutput().displayOutput("6. Exit Program");
    }

    private boolean isValidChoice(int choice) {
        return (choice >= 1 && choice <= 6);
    }

    private void getPlayerName(Scanner input, Region region) {
        Main.getOutput().displayOutput("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        region.getPlayerMatchHistory().displayPlayerMatchHistory(name);
    }

    private String switchRegion(Regions r, String currentRegion, Scanner input) {
        Set<String> set = r.getRegions().keySet();
        String[] regions = set.toArray(new String[set.size()]);
        Main.getOutput().displayOutput("Regions:");
        for (int i = 1; i <= regions.length; i++) {
            Main.getOutput().displayOutput(i + ". " + regions[i - 1]);
        }
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= regions.length) {
                Main.getOutput().displayOutput("Switching regions to " + regions[choice - 1]);
                return regions[choice - 1];
            }
        } catch(InputMismatchException e) {
            input.nextLine(); // clear input
        }
        Main.getOutput().displayOutput("Invalid region. Returning to main menu");
        return currentRegion;
    }
}
