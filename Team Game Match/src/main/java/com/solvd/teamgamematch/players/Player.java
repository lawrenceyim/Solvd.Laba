package com.solvd.teamgamematch.players;

import com.solvd.teamgamematch.game.Champions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Player {
    private String playerName;
    private HashMap<String, Integer> championMastery;  // Player's skill level for each champion (1 to 10)

    public Player(String playerName) {
        this.playerName = playerName;
        this.championMastery = generateChampionMastery();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getChampionMastery(String championName) {
        return championMastery.getOrDefault(championName, 1);
    }

    public void setChampionMastery(HashMap<String, Integer> championMastery) {
        this.championMastery = championMastery;
    }

    private HashMap<String, Integer> generateChampionMastery() {
        HashMap<String, Integer> championMastery = new HashMap<>();
        Random random = new Random();
        ArrayList<String> championNames = Champions.getInstance().getChampionNames();
        for (String championName : championNames) {
            championMastery.put(championName, random.nextInt(10) + 1); // Random number between 1-10
        }
        return championMastery;
    }


}
