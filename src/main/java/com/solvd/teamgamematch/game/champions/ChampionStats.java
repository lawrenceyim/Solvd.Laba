package com.solvd.teamgamematch.game.champions;

import com.solvd.teamgamematch.Main;
import com.solvd.teamgamematch.game.IDisplayStats;
import com.solvd.teamgamematch.utils.Pair;
import com.solvd.teamgamematch.utils.WaitForInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Stores the stats of every champion
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class ChampionStats implements IDisplayStats {
    /*
        The string is the champion's name
        The first int in the pair is the total number of games played by the champion
        The second int is the total number of games won by the champion
     */
    private final HashMap<String, Pair<Integer, Integer>> gamesWonByChampion;

    public ChampionStats() {
        gamesWonByChampion = new HashMap<>();
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        for (String championName : championNames) {
            gamesWonByChampion.put(championName, new Pair<>(0, 0));
        }
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

    @Override
    public void displayStats() {
        if (gamesWonByChampion.isEmpty()) {
            Main.getOutput().displayOutput("No player stats available");
            return;
        }
        List<String> names = new ArrayList<>(gamesWonByChampion.keySet());
        Collections.sort(names);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-30s %-15s %-15s %-25s%n\n", "Champion Name", "Games Played", "Games Won",
                "Champion Win Rate %"));
        for (String userName : names) {
            Pair<Integer, Integer> stat = gamesWonByChampion.getOrDefault(userName, new Pair<>(0, 0));
            int winRate;
            if (stat.getFirst() == 0) {
                winRate = 0;
            } else {
                winRate = (int) ((double) stat.getSecond() / stat.getFirst() * 100);
            }
            sb.append(String.format("%-30s %-15d %-15d %-25s%n", userName, stat.getFirst(), stat.getSecond(), winRate));
        }
        Main.getOutput().displayOutput(sb.toString());
        WaitForInput.waitForAnyUserInput();
    }
}
