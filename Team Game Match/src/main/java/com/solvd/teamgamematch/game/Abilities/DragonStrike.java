package com.solvd.teamgamematch.game.Abilities;

public class DragonStrike extends Ability {

    public DragonStrike() {
        super("Dragon Strike", 10,
                "Jarvan IV extends his lance, dealing physical damage and lowering the Armor of enemies " +
                        "in its path. Additionally, this will pull Jarvan to his Demacian Standard, knocking up " +
                        "enemies in his path.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
