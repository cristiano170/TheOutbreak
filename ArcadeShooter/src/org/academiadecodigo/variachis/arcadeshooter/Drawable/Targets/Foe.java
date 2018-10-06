package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class Foe extends Target {

    private int points = 200;

    // When the foe is hit it returns 200 points to be increased in the player's score
    @Override
    public int whenHit() {
        hit = true;
        return points;
    }


}
