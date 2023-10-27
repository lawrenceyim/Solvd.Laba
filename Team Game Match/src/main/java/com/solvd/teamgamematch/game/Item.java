package com.solvd.teamgamematch.game;

public class Item {
    private String itemName;
    private String[] statNames;
    private int[] statValues;

    public Item(String itemName, String[] statNames, int[] statValues) {
        this.itemName = itemName;
        this.statNames = statNames;
        this.statValues = statValues;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String[] getStatNames() {
        return statNames;
    }

    public void setStatNames(String[] statNames) {
        this.statNames = statNames;
    }

    public int[] getStatValues() {
        return statValues;
    }

    public void setStatValues(int[] statValues) {
        this.statValues = statValues;
    }
}
