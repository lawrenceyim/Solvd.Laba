package com.solvd.teamgamematch.game.champions;

import java.util.ArrayList;

/**
 * Instantiate and store all the Champion objects
 *
 * @author Lawrence Yim
 * @version 1.0 27 Oct 2023
 */

public class ChampionManager {
    private final static ChampionManager instance = new ChampionManager();
    public static ArrayList<Champion> champions;

    private ChampionManager() {
        champions = new ArrayList<>();
    }

    public static ChampionManager getInstance() {
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
