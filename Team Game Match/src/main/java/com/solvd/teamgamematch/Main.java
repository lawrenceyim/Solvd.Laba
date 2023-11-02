package com.solvd.teamgamematch;

import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.regions.Regions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 * Main method for the League of Legends match predictor
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Main {
    public static void main(String[] args) {
        Regions regions = new Regions();
        Region currentRegion = regions.getRegion("NA");

        int userChoice;
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu(currentRegion.getRegionName());
            try {
                userChoice = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine(); // clear input
                System.out.println("Invalid input");
                continue;
            }
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid selection");
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
                    System.out.println("Exiting");
                    System.exit(0);
            }
        }
    }

    private static void displayMenu(String regionName) {
        System.out.println("League of Legends simulator");
        System.out.println("Current region: " + regionName);
        System.out.println("1. New Match");
        System.out.println("2. View Players Stats");
        System.out.println("3. View Champion Win Rates");
        System.out.println("4. View Player Match History");
        System.out.println("5. Switch Region");
        System.out.println("6. Exit Program");
    }

    private static boolean isValidChoice(int choice) {
        return (choice >= 1 && choice <= 6);
    }

    private static void getPlayerName(Scanner input, Region region) {
        System.out.println("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        region.getPlayerMatchHistory().displayPlayerMatchHistory(name);
    }

    private static String switchRegion(Regions r, String currentRegion, Scanner input) {
        Set<String> set = r.getRegions().keySet();
        String[] regions = set.toArray(new String[set.size()]);
        System.out.println("Regions:");
        for (int i = 1; i <= regions.length; i++) {
            System.out.println(i + ". " + regions[i - 1]);
        }
        try {
            int choice = input.nextInt();
            if (choice >= 1 && choice <= regions.length) {
                System.out.println("Switching regions to " + regions[choice - 1]);
                return regions[choice - 1];
            }
        } catch(InputMismatchException e) {
            input.nextLine(); // clear input
        }
        System.out.println("Invalid region. Returning to main menu");
        return currentRegion;
    }
}
