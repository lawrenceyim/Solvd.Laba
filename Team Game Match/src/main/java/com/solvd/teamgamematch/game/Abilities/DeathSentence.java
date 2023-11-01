package com.solvd.teamgamematch.game.Abilities;

/**
 * Q ability for Thresh
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class DeathSentence extends Ability {
    public DeathSentence() {
        super("Death Sentence", 19,
                "Thresh binds an enemy in chains and pulls them toward him. Activating this ability " +
                        "a second time pulls Thresh to the enemy.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
