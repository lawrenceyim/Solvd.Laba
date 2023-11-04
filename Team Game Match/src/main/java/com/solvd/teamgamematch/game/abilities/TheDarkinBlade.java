package com.solvd.teamgamematch.game.abilities;

import com.solvd.teamgamematch.Main;

/**
 * Q ability for Aatrox
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class TheDarkinBlade extends Ability {
    public TheDarkinBlade() {
        super("The Darkin Blade", 14,
                "Aatrox slams his greatsword down, dealing physical damage. He can swing three times, " +
                        "each with a different area of effect");
    }

    @Override
    public void castAbility() {
        Main.getOutput().displayOutput("Aatrox used " + getAbilityName());
    }

}
