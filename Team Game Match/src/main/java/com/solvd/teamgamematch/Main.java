package com.solvd.teamgamematch;

import com.solvd.teamgamematch.game.ChampionStats;
import com.solvd.teamgamematch.game.MatchMaking;
import com.solvd.teamgamematch.players.Player;
import com.solvd.teamgamematch.players.PlayerMatchHistory;
import com.solvd.teamgamematch.players.PlayerStats;
import com.solvd.teamgamematch.players.Players;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main method for the League of Legends match predictor
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Main {
    public static void main(String[] args) {
        int userChoice;
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                userChoice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                continue;
            }
            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid selection");
                continue;
            }
            switch (userChoice) {
                case 1:
                    MatchMaking.matchMake();
                    break;
                case 2:
                    PlayerStats.getInstance().displayPlayerStats();
                    break;
                case 3:
                    ChampionStats.getInstance().displayChampionStats();
                    break;
                case 4:
                    getPlayerName(input);
                    break;
                default:
                    System.out.println("Exiting");
                    System.exit(0);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("League of Legends simulator");
        System.out.println("1. New Match");
        System.out.println("2. View Players Stats");
        System.out.println("3. View Champion Winrates");
        System.out.println("4. View Player Match History");
        System.out.println("5. Exit Program");
    }

    private static boolean isValidChoice(int choice) {
        return (choice >= 1 && choice <= 5);
    }

    private static void getPlayerName(Scanner input) {
        System.out.println("Enter the player's name:");
        input.nextLine(); // eliminate the \n from previous user input
        String name = input.nextLine().replace("\n", "").trim();
        PlayerMatchHistory.getInstance().displayPlayerMatchHistory(name);
    }
}
