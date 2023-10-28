package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Stores the stats for every player
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class PlayerStats {
    private static PlayerStats instance;
    /*
        First int in the pair represents the total number of games played by the player
        Second int is the total number of games won by the player
     */
    HashMap<String, Pair<Integer, Integer>> totalGamesPlayed;

    static {
        instance = new PlayerStats();
    }

    private PlayerStats() {
        this.totalGamesPlayed = new HashMap<>();
        ArrayList<Player> players = Players.getInstance().getPlayers();
    }

    public static PlayerStats getInstance() {
        if (instance == null) {
            instance = new PlayerStats();
        }
        return instance;
    }

    public void addNewGame(String playerName, boolean gameWon) {
        Pair<Integer, Integer> stats = totalGamesPlayed.getOrDefault(playerName, new Pair<>(0, 0));
        stats.setFirst(stats.getFirst() + 1);
        if (gameWon) {
            stats.setSecond(stats.getSecond() + 1);
        }
        totalGamesPlayed.put(playerName, stats);
    }

    public Pair<Integer, Integer> getPlayerStats(String playerName) {
        return totalGamesPlayed.getOrDefault(playerName, new Pair<>(0, 0));
    }

    public void displayPlayerStats() {
        if (totalGamesPlayed.isEmpty()) {
            System.out.println("No player stats available");
            return;
        }
        List<String> names = new ArrayList<>(totalGamesPlayed.keySet());
        Collections.sort(names);
        System.out.printf("%-30s %-15s %-15s %-15s%n", "Player Name", "Games Played", "Games Won", "Win Rate %");
        for (String playerName : names) {
            Pair<Integer, Integer> stat = totalGamesPlayed.getOrDefault(playerName, new Pair<>(0, 0));
            int winRate;
            if (stat.getFirst() == 0) {
                winRate = 0;
            } else {
                winRate = (int) ((double) stat.getSecond() / stat.getFirst() * 100);
            }
            System.out.printf("%-30s %-15d %-15d %-15s%n", playerName, stat.getFirst(), stat.getSecond(), winRate);
        }
    }
}
