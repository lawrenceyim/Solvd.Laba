package com.solvd.teamgamematch.game.champions;

import com.solvd.teamgamematch.game.abilities.Ability;

/**
 * Champion class that contains the champion name, role, and stats
 *
 * @version 1.0 27 Oct 2023
 * @author Lawrence Yim
 */

public class Champion {
    private String championName;
    private String mainRole;         // Primary role of the champion
    private int baseHealthPoints;    // Amount of health points at level 1
    private int baseManaPoints;      // Amount of mana points at level 1
    private int baseDamage;          // Amount of damage points at level 1
    private int baseMagic;           // Amount of magic points at level 1
    private int baseArmor;           // Amount of armor points at level 1
    private int baseMagicResist;     // Amount of magic resist points at level 1
    private Ability qAbility;        // Ability cast with the Q button

    public Champion(String championName, String mainRole, int baseHealthPoints, int baseManaPoints, int baseDamage,
                    int baseMagic, int baseArmor, int baseMagicResist) {
        this.championName = championName;
        this.mainRole = mainRole;
        this.baseHealthPoints = baseHealthPoints;
        this.baseManaPoints = baseManaPoints;
        this.baseDamage = baseDamage;
        this.baseMagic = baseMagic;
        this.baseArmor = baseArmor;
        this.baseMagicResist = baseMagicResist;
    }

    @Override
    public String toString() {
        return "Champion Name: " + championName +
                "\nChampion Role: " + mainRole;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public String getMainRole() {
        return mainRole;
    }

    public void setMainRole(String mainRole) {
        this.mainRole = mainRole;
    }

    public int getBaseHealthPoints() {
        return baseHealthPoints;
    }

    public void setBaseHealthPoints(int baseHealthPoints) {
        this.baseHealthPoints = baseHealthPoints;
    }

    public int getBaseManaPoints() {
        return baseManaPoints;
    }

    public void setBaseManaPoints(int baseManaPoints) {
        this.baseManaPoints = baseManaPoints;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getBaseMagic() {
        return baseMagic;
    }

    public void setBaseMagic(int baseMagic) {
        this.baseMagic = baseMagic;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public int getBaseMagicResist() {
        return baseMagicResist;
    }

    public void setBaseMagicResist(int baseMagicResist) {
        this.baseMagicResist = baseMagicResist;
    }

    public Ability getqAbility() {
        return qAbility;
    }

    public void setqAbility(Ability qAbility) {
        this.qAbility = qAbility;
    }
}
