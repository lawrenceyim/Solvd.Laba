package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.utils.GenerateRegions;

import java.util.HashMap;

public class Regions {
    private final HashMap<String, Region> regions;
    private Region currentRegion;

    public Regions() {
        regions = new HashMap<>();
        GenerateRegions.generateRegions(this);
    }

    @Override
    public String toString() {
        return "Current number of server regions: " + regions.size();
    }

    public void addRegion(String regionName) {
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
