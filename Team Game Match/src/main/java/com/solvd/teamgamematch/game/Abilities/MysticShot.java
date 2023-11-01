package com.solvd.teamgamematch.game.Abilities;

public class MysticShot extends Ability {

    public MysticShot() {
        super("Mystic Shot", 5.5,
                "Ezreal fires a damaging bolt of energy which reduces all of his cooldowns slightly " +
                        "if it strikes an enemy unit.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
