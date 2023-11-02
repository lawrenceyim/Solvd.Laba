package com.solvd.teamgamematch.game.Abilities;

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
        System.out.println("Ahri used " + getAbilityName());
    }
}
