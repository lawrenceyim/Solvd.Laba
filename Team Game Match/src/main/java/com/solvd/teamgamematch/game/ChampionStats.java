package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.utility.Pair;

import java.util.*;

/**
 * Stores the stats of every champion
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class ChampionStats {
    private static ChampionStats instance;

    /*
        The string is the champion's name
        The first int in the pair is the total number of games played by the champion
        The second int is the total number of games won by the champion
     */
    private HashMap<String, Pair<Integer, Integer>> gamesWonByChampion;

    static {
        instance = new ChampionStats();
    }

    private ChampionStats() {
        gamesWonByChampion = new HashMap<>();
        ArrayList<String> championNames = Champions.getInstance().getChampionNames();
        for (String championName : championNames) {
            gamesWonByChampion.put(championName, new Pair<>(0, 0));
        }
    }

    public static ChampionStats getInstance() {
        if (instance == null) {
            instance = new ChampionStats();
        }
        return instance;
    }

    public void addNewGame(String championName, boolean wonGame) {
        Pair<Integer, Integer> stats = gamesWonByChampion.getOrDefault(championName, new Pair<>(0, 0));
        stats.setFirst(stats.getFirst() + 1);
        if (wonGame) {
            stats.setSecond(stats.getSecond() + 1);
        }
       gamesWonByChampion.put(championName, stats);
    }

    public Pair<Integer, Integer> getChampionStats(String championName) {
        return gamesWonByChampion.getOrDefault(championName, new Pair<>(0, 0));
    }

    public void displayChampionStats() {
        if (gamesWonByChampion.isEmpty()) {
            System.out.println("No player stats available");
            return;
        }
        List<String> names = new ArrayList<>(gamesWonByChampion.keySet());
        Collections.sort(names);
        System.out.printf("%-30s %-15s %-15s %-25s%n", "Champion Name", "Games Played", "Games Won", "Champion Win Rate %");
        for (String playerName : names) {
            Pair<Integer, Integer> stat = gamesWonByChampion.getOrDefault(playerName, new Pair<>(0, 0));
            int winRate = (int) ((double) stat.getSecond() / stat.getFirst() * 100);
            System.out.printf("%-30s %-15d %-15d %-25s%n", playerName, stat.getFirst(), stat.getSecond(), winRate);
        }
    }
}
