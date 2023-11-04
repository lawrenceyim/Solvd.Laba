package com.solvd.teamgamematch.game.abilities;

import com.solvd.teamgamematch.Main;

/**
 * Q ability for Ahri
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class OrbOfDeception extends Ability {
    public OrbOfDeception() {
        super("Orb of Deception", 7,
                "Ahri sends out and pulls back her orb, dealing magic damage on the way out and true " +
                        "damage on the way back.");
    }

    @Override
    public void castAbility() {
        Main.getOutput().displayOutput("Ahri used " + getAbilityName());
    }
}
