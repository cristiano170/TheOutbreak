package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Movable;

public class Victim extends Target implements Movable {

    private final int hpPoints = 1;


    public Victim(String fileName) {
        super(fileName);
    }

    // When the victim is hit it returns one point to be decreased in the player's Hp
    @Override
    public int whenHit() {
        hit = true;
        return hpPoints;
    }

    @Override
    public void move() {

    }
}
