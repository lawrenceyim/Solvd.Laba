package com.solvd.teamgamematch.game.champions;

public enum ChampionRole {
    ADC("Attack Damage Carry"),
    JG("Jungle"),
    MID("Mid Lane"),
    SUPP("Support"),
    TOP("Lane");

    String roleName;

    ChampionRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
