package com.solvd.teamgamematch.utility;

import com.solvd.teamgamematch.game.champions.ChampionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GenerateChampionMastery {
    public static HashMap<String, Integer> generateChampionMastery() {
        HashMap<String, Integer> championMastery = new HashMap<>();
        Random random = new Random();
        ArrayList<String> championNames = ChampionManager.getInstance().getChampionNames();
        for (String championName : championNames) {
            championMastery.put(championName, random.nextInt(10) + 1); // Random number between 1-10
        }
        return championMastery;
    }
}
