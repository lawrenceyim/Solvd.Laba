package com.solvd.teamgamematch.game.Abilities;

/**
 * Q ability for LuLu
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
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
