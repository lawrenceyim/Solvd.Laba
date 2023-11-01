package com.solvd.teamgamematch.game.Abilities;

/**
 * Q ability for Caitlyn
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class PiltoverPeacemaker extends Ability {
    public PiltoverPeacemaker() {
        super("Piltover Peacemaker", 10,
                "Caitlyn revs up her rifle for 1 second to unleash a penetrating shot that deals " +
                        "physical damage (deals less damage to subsequent targets).");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
