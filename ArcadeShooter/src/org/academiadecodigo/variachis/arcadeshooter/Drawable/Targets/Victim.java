package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class Victim extends Target {

    private int hpPoints = 1;

    // When the victim is hit it returns one point to be decreased in the player's Hp
    @Override
    public int whenHit() {
        hit = true;
        return hpPoints;
    }

}
