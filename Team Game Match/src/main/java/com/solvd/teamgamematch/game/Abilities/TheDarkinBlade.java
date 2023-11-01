package com.solvd.teamgamematch.game.Abilities;

public class TheDarkinBlade extends Ability {
    public TheDarkinBlade() {
        super("The Darkin Blade", 14,
                "Aatrox slams his greatsword down, dealing physical damage. He can swing three times, " +
                        "each with a different area of effect");
    }

    @Override
    public void castAbility() {
        System.out.println(getAbilityName() + " used " + getAbilityName());
    }

}
