package com.solvd.teamgamematch.game.Abilities;

public class CommandAttack extends Ability {
    public CommandAttack() {
        super("Command: Attack", 6,
                "Orianna commands her Ball to fire toward a target location, dealing magic damage to " +
                        "targets along the way (deals less damage to subsequent targets). Her Ball remains at the " +
                        "target location after.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
