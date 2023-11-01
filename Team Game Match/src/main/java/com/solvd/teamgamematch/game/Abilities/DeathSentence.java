package com.solvd.teamgamematch.game.Abilities;

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
