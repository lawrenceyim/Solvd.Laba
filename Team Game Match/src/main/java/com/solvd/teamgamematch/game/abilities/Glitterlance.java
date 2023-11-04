package com.solvd.teamgamematch.game.abilities;

import com.solvd.teamgamematch.Main;

/**
 * Q ability for Lulu
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class Glitterlance extends Ability {

    public Glitterlance() {
        super("Glitterlance", 7,
                "Pix and Lulu each fire a bolt of magical energy that damages and heavily slows all " +
                        "enemies it hits.");
    }

    @Override
    public void castAbility() {
        Main.getOutput().displayOutput("Lulu used " + getAbilityName());
    }
}
