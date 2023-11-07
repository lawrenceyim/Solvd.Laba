package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.utility.GenerateChampions;

import java.util.ArrayList;

/**
 * Instantiate and store all the Champion objects
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class ChampionManager {
    private static ChampionManager instance;
    public static ArrayList<Champion> champions;

    static {
        instance = new ChampionManager();
    }

    private ChampionManager() {
        champions = GenerateChampions.generateChampions();
    }

    public static ChampionManager getInstance() {
        if (instance == null) {
            instance = new ChampionManager();
        }
        return instance;
    }

    public ArrayList<Champion> getChampions() {
        return champions;
    }

    public void setChampions(ArrayList<Champion> champions) {
        this.champions = champions;
    }

    public ArrayList<String> getChampionNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Champion c : champions) {
            names.add(c.getChampionName());
        }
        return names;
    }
}
