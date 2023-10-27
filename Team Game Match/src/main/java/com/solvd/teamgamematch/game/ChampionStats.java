package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.utility.Pair;

import java.util.HashMap;

public class ChampionStats {
    /*
        The string is the champion's name
        The first int in the pair is the total number of games played by the champion
        The second int is the total number of games won by the champion
     */
    private HashMap<String, Pair<Integer, Integer>> gamesWonByChampion;


    public ChampionStats() {
        gamesWonByChampion = new HashMap<>();
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
}
