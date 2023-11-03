package com.solvd.teamgamematch.game.abilities;

/**
 * Q ability for Janna
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class HowlingGale extends Ability {
    public HowlingGale() {
        super("Howling Gale", 12,
                "By creating a localized change in pressure and temperature, Janna is able to create " +
                        "a small storm that grows in size with time. She can activate the spell again to release " +
                        "the storm. On release this storm will fly towards the direction it was cast in, dealing " +
                        "damage and knocking away any enemies in its path.");
    }

    @Override
    public void castAbility() {
        System.out.println("Janna used " + getAbilityName());
    }
}
