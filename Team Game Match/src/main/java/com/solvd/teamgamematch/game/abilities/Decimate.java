package com.solvd.teamgamematch.game.abilities;

/**
 * Q ability for Darius
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class Decimate extends Ability {
    public Decimate() {
        super("Decimate", 9,
                "Darius winds up and swings his axe in a wide circle. Enemies struck by the blade take " +
                        "more damage than those struck by the handle. Darius heals based on enemy champions and large " +
                        "monsters hit by the blade.");
    }

    @Override
    public void castAbility() {
        System.out.println("Darius used " + getAbilityName());
    }
}
