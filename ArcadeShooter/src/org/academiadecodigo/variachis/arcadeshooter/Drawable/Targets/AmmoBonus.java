package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class AmmoBonus extends Target {


    private int ammoBonus = 5;


    // When the ammoBonus is hit it returns five bullets to be increased in the player's weapon
    @Override
    public int whenHit() {
        hit = true;
        return ammoBonus;
    }


}
