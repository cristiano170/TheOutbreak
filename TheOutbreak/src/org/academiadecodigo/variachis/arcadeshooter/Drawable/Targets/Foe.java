package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Movable;

public class Foe extends Target implements Movable {

    private final int points = 200;

    public Foe(String fileName){
        super(fileName);
    }

    // When the foe is hit it returns 200 points to be increased in the player's score
    @Override
    public int whenHit() {
        hit = true;
        return points;
    }

    @Override
    public void move() {

    }
}
