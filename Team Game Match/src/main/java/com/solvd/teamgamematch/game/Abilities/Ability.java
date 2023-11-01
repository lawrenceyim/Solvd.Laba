package com.solvd.teamgamematch.game.Abilities;

public abstract class Ability {
    private String abilityName;
    private String abilityDescription;
    private double abilityCoolDown;

    public Ability(String abilityName, double abilityCoolDown, String abilityDescription) {
        this.abilityName = abilityName;
        this.abilityCoolDown = abilityCoolDown;
        this.abilityDescription = abilityDescription;
    }

    public abstract void castAbility();

    @Override
    public String toString() {
        return "Ability Name: " + getAbilityName() +
                "\nAbility Cooldown: " + getAbilityCoolDown() +
                "\nAbility Description: " + getAbilityDescription();
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    public double getAbilityCoolDown() {
        return abilityCoolDown;
    }

    public void setAbilityCoolDown(float abilityCoolDown) {
        this.abilityCoolDown = abilityCoolDown;
    }
}
