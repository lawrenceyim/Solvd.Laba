package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.exceptions.InsufficientChampionException;
import com.solvd.teamgamematch.exceptions.InsufficientPlayerException;
import com.solvd.teamgamematch.exceptions.InvalidRegionException;
import com.solvd.teamgamematch.game.champions.ChampionManager;
import com.solvd.teamgamematch.game.champions.ChampionStats;
import com.solvd.teamgamematch.game.players.Player;
import com.solvd.teamgamematch.game.players.PlayerMatchHistory;
import com.solvd.teamgamematch.game.players.PlayerStats;
import com.solvd.teamgamematch.regions.Region;
import com.solvd.teamgamematch.utils.Sleep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Implementation of the match making algorithm to randomly generate two teams of five players and determine the outcome
 *
 * @author Lawrence Yim
 * @version 1.0 25 Oct 2023
 */

public class MatchMaking {
    public static void matchMake(Region region) {
        if (region == null) {
            throw new InvalidRegionException("Matchmaking cannot start with a null region.");
        }
        // Players and champions will be randomly selected and paired based on their arraylist index
        // Indices 0-4 will be team one and 5-9 will be team two
        ArrayList<Player> players = generateRandomTeams(region);
        ArrayList<String> champions = randomlySelectChampions();

        printTeams(players, champions);
        fakeWaiting();
        boolean teamOneWon = determineResult(players, champions);
        printResults(teamOneWon);
        updateStats(players, champions, teamOneWon, region);
    }

    // Used to populate the statistics with matches on application startup
    // The region object is guaranteed to exist because it is called inside a generator to generate
    // matches on application startup
    public static void matchMakeWithNoOutput(Region region) {
        ArrayList<Player> players = generateRandomTeams(region);
        ArrayList<String> champions = randomlySelectChampions();
        boolean teamOneWon = determineResult(players, champions);
        updateStats(players, champions, teamOneWon, region);
    }

    private static ArrayList<Player> generateRandomTeams(Region region) {
        ArrayList<Player> players = region.getPlayers().getPlayers();
        if (players.size() < 10) {
            throw new InsufficientPlayerException("Insufficient number of players to start matchmaking");
        }

        HashSet<Integer> randomPlayers = new HashSet<>();
        Random random = new Random();

        while (randomPlayers.size() < 10) {
            int randomIndex = random.nextInt(players.size());
            randomPlayers.add(randomIndex);
        }

        ArrayList<Player> selectedPlayers = new ArrayList<>();
        randomPlayers.forEach(i -> selectedPlayers.add(players.get(i)));

        return selectedPlayers;
    }

    private static ArrayList<String> randomlySelectChampions() {
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        if (championNames.size() < 10) {
            throw new InsufficientChampionException("Insufficient number of champion of players");
        }

        HashSet<Integer> randomChampions = new HashSet<>();
        Random random = new Random();

        while (randomChampions.size() < 10) {
            int randomIndex = random.nextInt(championNames.size());
            randomChampions.add(randomIndex);
        }

        ArrayList<String> selectedChampions = new ArrayList<>();
        randomChampions.forEach(i -> selectedChampions.add(championNames.get(i)));

        return selectedChampions;
    }

    private static boolean determineResult(ArrayList<Player> players, ArrayList<String> champions) {
        int teamOneScore = IntStream.rangeClosed(0, 4).map(i -> players.get(i).getChampionMastery(champions.get(i))).sum();
        int teamTwoScore = IntStream.rangeClosed(5, 9).map(i -> players.get(i).getChampionMastery(champions.get(i))).sum();

        return teamOneScore >= teamTwoScore;  // Team one wins if the scores are equal
    }

    private static void printTeams(ArrayList<Player> players, ArrayList<String> champions) {
        StringBuilder sb = new StringBuilder();
        sb.append("Team One:\n");
        IntStream.rangeClosed(0, 4).forEach(i -> {
            sb.append(players.get(i).getUserName() + " is playing " + champions.get(i) +
                    ". Champion Mastery Level: " + players.get(i).getChampionMastery(champions.get(i)) + "/10\n");
        });
        IntStream.rangeClosed(5, 9).forEach(i -> {
            sb.append(players.get(i).getUserName() + " is playing " + champions.get(i) +
                    ". Champion Mastery Level: " + players.get(i).getChampionMastery(champions.get(i)) + "/10\n");
        });
        sb.append("Team Two:\n");
        Main.getOutput().displayOutput(sb.toString());
    }

    private static void printResults(boolean teamOneWon) {
        if (teamOneWon) {
            Main.getOutput().displayOutput("Team One wins!");
        } else {
            Main.getOutput().displayOutput("Team Two wins!");
        }
    }

    private static void updateStats(ArrayList<Player> players, ArrayList<String> champions, boolean teamOneWon,
                                    Region region) {
        PlayerMatchHistory matchHistory = region.getPlayerMatchHistory();
        ChampionStats championStats = region.getChampionStats();
        PlayerStats playerStats = region.getPlayerStats();

        IntStream.rangeClosed(0, 4).forEach(i -> {
            matchHistory.addPlayerMatch(players.get(i).getUserName(), champions.get(i), teamOneWon);
            championStats.addNewGame(champions.get(i), teamOneWon);
            playerStats.addNewGame(players.get(i).getUserName(), teamOneWon);
        });
        IntStream.rangeClosed(5, 9).forEach(i -> {
            matchHistory.addPlayerMatch(players.get(i).getUserName(), champions.get(i), !teamOneWon);
            championStats.addNewGame(champions.get(i), !teamOneWon);
            playerStats.addNewGame(players.get(i).getUserName(), !teamOneWon);
        });
    }

    private static void fakeWaiting() {
        Main.getOutput().displayOutput("Match in progress.");
        Sleep.sleepForOneSecond();

        Main.getOutput().displayOutput("Match in progress..");
        Sleep.sleepForOneSecond();

        Main.getOutput().displayOutput("Match in progress...");
        Sleep.sleepForOneSecond();
    }
}
