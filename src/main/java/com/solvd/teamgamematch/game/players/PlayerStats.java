package com.solvd.teamgamematch.game.players;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.game.IDisplayStats;
import com.solvd.teamgamematch.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Stores the stats for every player
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class PlayerStats implements IDisplayStats {
    /*
        First int in the pair represents the total number of games played by the player
        Second int is the total number of games won by the player
     */
    HashMap<String, Pair<Integer, Integer>> totalGamesPlayed;

    public PlayerStats() {
        this.totalGamesPlayed = new HashMap<>();
    }

    public void addNewGame(String userName, boolean gameWon) {
        Pair<Integer, Integer> stats = totalGamesPlayed.getOrDefault(userName, new Pair<>(0, 0));
        stats.setFirst(stats.getFirst() + 1);
        if (gameWon) {
            stats.setSecond(stats.getSecond() + 1);
        }
        totalGamesPlayed.put(userName, stats);
    }

    public Pair<Integer, Integer> getPlayerStats(String userName) {
        return totalGamesPlayed.getOrDefault(userName, new Pair<>(0, 0));
    }

    @Override
    public void displayStats() {
        if (totalGamesPlayed.isEmpty()) {
            Main.getOutput().displayOutput("No player stats available");
            return;
        }
        List<String> names = new ArrayList<>(totalGamesPlayed.keySet());
        Collections.sort(names);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-30s %-15s %-15s %-15s%n\n", "Player Name", "Games Played", "Games Won", "Win Rate %"));
        names.stream().forEach(userName -> {
            Pair<Integer, Integer> stat = totalGamesPlayed.getOrDefault(userName, new Pair<>(0, 0));
            int winRate;
            if (stat.getFirst() == 0) {
                winRate = 0;
            } else {
                winRate = (int) ((double) stat.getSecond() / stat.getFirst() * 100);
            }
            sb.append(String.format("%-30s %-15d %-15d %-15s%n", userName, stat.getFirst(), stat.getSecond(), winRate));

        });
        Main.getOutput().displayOutput(sb.toString());
    }
}
