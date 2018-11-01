package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Main;
import org.academiadecodigo.variachis.arcadeshooter.Movable;

import java.util.ConcurrentModificationException;
import java.util.Random;

public class Foe extends Target implements Movable {

    private final int points = 200;

    public Foe(String fileName) {
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
        int rmd = (int) (Math.random() * 2);

        if (rmd == 1) {
            if (picture.getX() < 650) {
                picture.translate(20, 0);
            }

        } else {
            if (picture.getX() > 40) {
                picture.translate(-20, 0);
            }
        }
    }

}
