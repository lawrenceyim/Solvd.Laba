package com.solvd.teamgamematch.game.Abilities;

public class PaddleStar extends Ability {
    public PaddleStar() {
        super("Paddle Star", 8.5,
                "Zoe fires a missile that she can redirect in flight. Deals more damage the longer it " +
                        "flies in a straight line.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
