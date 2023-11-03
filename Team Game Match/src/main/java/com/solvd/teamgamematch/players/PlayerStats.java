package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;
import com.solvd.teamgamematch.utility.WaitForInput;

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
    /*
        First int in the pair represents the total number of games played by the player
        Second int is the total number of games won by the player
     */
    HashMap<String, Pair<Integer, Integer>> totalGamesPlayed;

    public PlayerStats() {
        this.totalGamesPlayed = new HashMap<>();
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
        WaitForInput.waitForAnyUserInput();
    }
}
