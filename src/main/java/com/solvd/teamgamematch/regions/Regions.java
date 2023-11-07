package com.solvd.teamgamematch.regions;

import java.util.HashMap;

public class Regions {
    private final HashMap<String, Region> regions;
    private Region currentRegion;

    public Regions() {
        regions = new HashMap<>();
        regions.put("NA", new Region("NA"));
        regions.put("EUN", new Region("EUN"));
        regions.put("EUW", new Region("EUW"));
        regions.put("KR", new Region("KR"));
        regions.put("BR", new Region("BR"));
        regions.put("JP", new Region("JP"));
        regions.put("LAN", new Region("LAN"));
        regions.put("LAS", new Region("LAS"));
        regions.put("OCE", new Region("OCE"));
        currentRegion = regions.get("NA");
    }

    @Override
    public String toString() {
        return "Current number of server regions: " + regions.size();
    }

    public void AddRegion(String regionName) {
        regions.put(regionName, new Region(regionName));
    }

    public HashMap<String, Region> getRegions() {
        return regions;
    }

    public Region getRegion(String regionName) {
        return regions.get(regionName);
    }

    public Region getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(Region newRegion) {
        this.currentRegion = newRegion;
    }

    public void setCurrentRegion(String newRegion) {
        this.currentRegion = getRegion(newRegion);
    }
}
