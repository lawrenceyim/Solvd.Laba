package com.solvd.teamgamematch.game;

import com.solvd.teamgamematch.utility.Pair;

import java.util.ArrayList;

/**
 * Item class that contains the item name and stats
 *
 * @version 1.0 25 Oct 2023
 * @author Lawrence Yim
 */

public class Item {
    private String itemName;
    // String represents the stat name, Integer represents the stat value
    // e.g. new Pair<String, Integer> (Health Points, 50)
    private ArrayList<Pair<String, Integer>> stats;

    public Item(String itemName, ArrayList<Pair<String, Integer>> stats) {
        this.itemName = itemName;
        this.stats = stats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item Name: " + itemName);
        for (Pair<String, Integer> stat : stats) {
            sb.append(stat.getFirst() + ": " + stat.getSecond());
        }
        return sb.toString();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ArrayList<Pair<String, Integer>> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Pair<String, Integer>> stats) {
        this.stats = stats;
    }
}
