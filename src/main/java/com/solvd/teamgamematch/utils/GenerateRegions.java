package com.solvd.teamgamematch.utils;

import com.solvd.teamgamematch.regions.Regions;

public class GenerateRegions {
    public static void generateRegions(Regions regions) {
        regions.addRegion("NA");
        regions.addRegion("EUN");
        regions.addRegion("EUW");
        regions.addRegion("KR");
        regions.addRegion("JP");
        regions.setCurrentRegion("NA");
    }
}
