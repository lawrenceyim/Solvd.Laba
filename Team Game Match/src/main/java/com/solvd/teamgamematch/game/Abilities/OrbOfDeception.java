package com.solvd.teamgamematch.game.Abilities;

public class OrbOfDeception extends Ability {
    public OrbOfDeception() {
        super("Orb of Deception", 7,
                "Ahri sends out and pulls back her orb, dealing magic damage on the way out and true " +
                        "damage on the way back.");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }
}
