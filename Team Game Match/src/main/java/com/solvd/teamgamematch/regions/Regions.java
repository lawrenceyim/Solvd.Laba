package com.solvd.teamgamematch.regions;

import java.util.HashMap;

public class Regions {
    HashMap<String, Region> regions;

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
}
