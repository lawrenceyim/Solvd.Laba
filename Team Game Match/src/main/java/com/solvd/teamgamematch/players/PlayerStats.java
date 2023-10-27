package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.utility.Pair;

import java.util.HashMap;

public class PlayerStats {
    /*
        First int in the pair represents the total number of games played by the player
        Second int is the total number of games won by the player
     */
    HashMap<String, Pair<Integer, Integer>> totalGamesPlayed;

    public PlayerStats() {
        this.totalGamesPlayed = new HashMap<>();
    }

    public void addGame(String playerName, boolean gameWon) {
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
}
