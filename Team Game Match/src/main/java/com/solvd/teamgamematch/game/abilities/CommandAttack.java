package com.solvd.teamgamematch.game.abilities;

/**
 * Q ability for Oriana
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class CommandAttack extends Ability {
    public CommandAttack() {
        super("Command: Attack", 6,
                "Orianna commands her Ball to fire toward a target location, dealing magic damage to " +
                        "targets along the way (deals less damage to subsequent targets). Her Ball remains at the " +
                        "target location after.");
    }

    @Override
    public void castAbility() {
        System.out.println("Orianna used " + getAbilityName());
    }
}
