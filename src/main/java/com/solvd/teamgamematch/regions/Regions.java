package com.solvd.teamgamematch.regions;

import com.solvd.teamgamematch.utils.Generator;

import java.util.HashMap;

public class Regions {
    private final HashMap<RegionName, Region> regions;
    private Region currentRegion;

    public Regions() {
        regions = new HashMap<>();
        Generator.generateRegions(this);
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
