package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class AmmoBonus extends Target {



    private int ammoBonus = 5;

    @Override
    public int whenHit() {
        hit = true;
        return ammoBonus;
    }
}
