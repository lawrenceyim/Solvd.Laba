package com.solvd.teamgamematch.person;

public enum AccessLevel {
    Administrator("Administrator"), Standard("Standard"), Guest("Guest");

    String name;

    AccessLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
