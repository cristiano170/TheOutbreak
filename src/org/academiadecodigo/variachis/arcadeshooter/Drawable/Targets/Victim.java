package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Movable;

import java.util.ConcurrentModificationException;

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
    public void move() throws java.util.ConcurrentModificationException {
        int rmd = (int) (Math.random() * 2);
        try {
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
        catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
