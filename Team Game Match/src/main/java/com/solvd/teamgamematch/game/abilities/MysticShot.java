package com.solvd.teamgamematch.game.abilities;

import com.solvd.teamgamematch.Main;

/**
 * Q ability for Ezreal
 *
 * @version 1.0 1 Nov 2023
 * @author Lawrence Yim
 */

public class MysticShot extends Ability {

    public MysticShot() {
        super("Mystic Shot", 5.5,
                "Ezreal fires a damaging bolt of energy which reduces all of his cooldowns slightly " +
                        "if it strikes an enemy unit.");
    }

    @Override
    public void castAbility() {
        Main.getOutput().displayOutput("Ezreal used " + getAbilityName());
    }
}
