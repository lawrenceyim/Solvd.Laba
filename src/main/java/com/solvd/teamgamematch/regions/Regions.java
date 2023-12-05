package com.solvd.teamgamematch.regions;

import java.util.HashMap;

public class Regions {
    private static final Regions instance = new Regions();
    private final HashMap<RegionName, Region> regions;
    private Region currentRegion;

    public static Regions getInstance() {
        return instance;
    }

    private Regions() {
        regions = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Current number of server regions: " + regions.size();
    }

    public void addRegion(RegionName regionName) {
        regions.put(regionName, new Region(regionName));
    }

    public HashMap<RegionName, Region> getRegions() {
        return regions;
    }

    public Region getRegion(RegionName regionName) {
        return regions.get(regionName);
    }

    public Region getCurrentRegion() {
        return currentRegion;
    }

    public void setCurrentRegion(RegionName newRegion) {
        this.currentRegion = getRegion(newRegion);
    }
}
