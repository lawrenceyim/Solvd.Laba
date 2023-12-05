package com.solvd.teamgamematch.game.champions;

import com.solvd.teamgamematch.utils.Generator;

import java.util.ArrayList;

/**
 * Instantiate and store all the Champion objects
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class ChampionManager {
    private static ChampionManager instance;
    public static ArrayList<Champion> champions;

    static {
        instance = new ChampionManager();
    }

    private ChampionManager() {
        champions = new ArrayList<>();
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
        ChampionManager.champions = champions;
    }

    public ArrayList<String> getChampionNames() {
        ArrayList<String> names = new ArrayList<>();
        champions.stream().forEach(champion -> names.add(champion.getChampionName()));
        return names;
    }
}
