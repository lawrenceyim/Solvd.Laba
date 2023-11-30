package com.solvd.teamgamematch.regions;

public enum RegionName {
    NA("North America"), EU("Europe"), SA("South America"), OCE("Oceania"), KR("Korea"), JP("Japan");

    private String name;

    RegionName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
