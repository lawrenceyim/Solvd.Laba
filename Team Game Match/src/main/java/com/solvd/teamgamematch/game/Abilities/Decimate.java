package com.solvd.teamgamematch.game.Abilities;

public class Decimate extends Ability {
    public Decimate() {
        super("Decimate", 9,
                "Darius winds up and swings his axe in a wide circle. Enemies struck by the blade take " +
                        "more damage than those struck by the handle. Darius heals based on enemy champions and large " +
                        "monsters hit by the blade.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
