package com.solvd.teamgamematch.game.abilities;

import com.solvd.teamgamematch.Main;

/**
 * Q ability for Zoe
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class PaddleStar extends Ability {
    public PaddleStar() {
        super("Paddle Star", 8.5,
                "Zoe fires a missile that she can redirect in flight. Deals more damage the longer it " +
                        "flies in a straight line.");
    }

    @Override
    public void castAbility() {
        Main.getOutput().displayOutput("Zoe used " + getAbilityName());
    }
}
