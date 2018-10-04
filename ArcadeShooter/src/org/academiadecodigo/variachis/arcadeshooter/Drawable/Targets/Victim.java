package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class Victim extends Target {

    private int hpPoints = 1;

    @Override
    public int whenHit() {
        hit = true;
        return hpPoints;
    }
}
