package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;


import org.academiadecodigo.variachis.arcadeshooter.Player;

public class Foe extends Target {

    private int points = 200;

    @Override
    public int whenHit() {
        hit = true;
        return points;
    }
}
