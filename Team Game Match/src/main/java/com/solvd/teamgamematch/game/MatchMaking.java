package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.players.Player;
import com.solvd.teamgamematch.players.PlayerMatchHistory;
import com.solvd.teamgamematch.players.PlayerStats;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.utility.Sleep;
import com.solvd.teamgamematch.utility.WaitForInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Implementation of the match making algorithm to randomly generate two teams of five players and determine the outcome
 *
 * @version 1.0 25 Oct 2023
 * @author Lawrence Yim
 */

public class MatchMaking {
    public static void matchMake(Region region) {
        try {
            // Players and champions will be randomly selected and paired based on their arraylist index
            // Indices 0-4 will be team one and 5-9 will be team two
            ArrayList<Player> players = generateRandomTeams(region);
            ArrayList<String> champions = randomlySelectChampions();

            printTeams(players, champions);

            fakeWaiting();

            boolean teamOneWon = determineResult(players, champions);

            printResults(teamOneWon);

            updateStats(players, champions, teamOneWon, region);

            WaitForInput.waitForAnyUserInput();
        } catch (RuntimeException e) {
            System.out.println("Returning to main menu");
        }
    }

    // Used to populate the statistics with matches on application startup
    public static void matchMakeWithNoOutput(Region region) {
        try {
            ArrayList<Player> players = generateRandomTeams(region);
            ArrayList<String> champions = randomlySelectChampions();
            boolean teamOneWon = determineResult(players, champions);
            updateStats(players, champions, teamOneWon, region);
        } catch (RuntimeException e) {}
    }

    private static ArrayList<Player> generateRandomTeams(Region region) {
        ArrayList<Player> players = region.getPlayers().getPlayers();

        if (players.size() < 10) {
            throw new RuntimeException("Insufficient number of players to start matchmaking");
        }

        HashSet<Integer> randomPlayers = new HashSet<>();
        Random random = new Random();

        while (randomPlayers.size() < 10) {
            int randomIndex = random.nextInt(players.size());
            randomPlayers.add(randomIndex);
        }

        ArrayList<Player> selectedPlayers = new ArrayList<>();
        for (Integer playerIndex : randomPlayers) {
            selectedPlayers.add(players.get(playerIndex));
        }

        return selectedPlayers;
    }

    private static ArrayList<String> randomlySelectChampions() {
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        HashSet<Integer> randomChampions = new HashSet<>();
        Random random = new Random();

        while (randomChampions.size() < 10) {
            int randomIndex = random.nextInt(championNames.size());
            randomChampions.add(randomIndex);
        }

        ArrayList<String> selectedChampions = new ArrayList<>();
        for (Integer championIndex : randomChampions) {
            selectedChampions.add(championNames.get(championIndex));
        }
        return selectedChampions;
    }

    private static boolean determineResult(ArrayList<Player> players, ArrayList<String> champions) {
        int teamOneScore = 0;
        int teamTwoScore = 0;

        for (int i = 0; i < 5; i++) {
            teamOneScore += players.get(i).getChampionMastery(champions.get(i));
        }
        for (int i = 5; i < 10; i++) {
            teamTwoScore += players.get(i).getChampionMastery(champions.get(i));
        }

        return teamOneScore >= teamTwoScore;  // Team one wins if the scores are equal
    }

    private static void printTeams(ArrayList<Player> players, ArrayList<String> champions) {
        System.out.println("Team One:");
        for (int i = 0; i < 5; i++) {
            System.out.println(players.get(i).getUserName() + " is playing " + champions.get(i) +
                    ". Champion Mastery Level: " + players.get(i).getChampionMastery(champions.get(i)) + "/10");
        }
        System.out.println("Team Two:");
        for (int i = 5; i < 10; i++) {
            System.out.println(players.get(i).getUserName() + " is playing " + champions.get(i) +
                    ". Champion Mastery Level: " + players.get(i).getChampionMastery(champions.get(i)) + "/10");
        }
    }

    private static void printResults(boolean teamOneWon) {
        if (teamOneWon) {
            System.out.println("Team One wins!");
        } else {
            System.out.println("Team Two wins!");
        }
    }

    private static void updateStats(ArrayList<Player> players, ArrayList<String> champions, boolean teamOneWon,
                                    Region region) {
        PlayerMatchHistory matchHistory = region.getPlayerMatchHistory();
        ChampionStats championStats = region.getChampionStats();
        PlayerStats playerStats = region.getPlayerStats();

        for (int i = 0; i < 5; i++) {
            matchHistory.addPlayerMatch(players.get(i).getUserName(), champions.get(i), teamOneWon);
            championStats.addNewGame(champions.get(i), teamOneWon);
            playerStats.addNewGame(players.get(i).getUserName(), teamOneWon);
        }
        for (int i = 5; i < 10; i++) {
            matchHistory.addPlayerMatch(players.get(i).getUserName(), champions.get(i), !teamOneWon);
            championStats.addNewGame(champions.get(i), !teamOneWon);
            playerStats.addNewGame(players.get(i).getUserName(), !teamOneWon);
        }
    }

    private static void fakeWaiting() {
        System.out.println("Match in progress.");
        Sleep.sleepForOneSecond();

        System.out.println("Match in progress..");
        Sleep.sleepForOneSecond();

        System.out.println("Match in progress...");
        Sleep.sleepForOneSecond();
    }
}
