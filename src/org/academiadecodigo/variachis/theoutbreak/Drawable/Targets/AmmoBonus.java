package org.academiadecodigo.variachis.theoutbreak.Drawable.Targets;

public class AmmoBonus extends Target {


    private final int ammoBonus = 5;

    public AmmoBonus(String fileName) {
        super(fileName);
    }


    // When the ammoBonus is hit it returns five bullets to be increased in the player's weapon
    @Override
    public int whenHit() {
        hit = true;
        return ammoBonus;
    }


}
