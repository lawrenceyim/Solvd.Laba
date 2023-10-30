package com.solvd.teamgamematch.regions;

import java.util.ArrayList;
import java.util.HashMap;

public class Regions {
    private static Regions instance;
    HashMap<String, Region> regions;

    static {
        instance = new Regions();
    }

    public static Regions getInstance() {
        if (instance == null) {
            instance = new Regions();
        }
        return instance;
    }

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
