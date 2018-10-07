package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Movable;

public abstract class Target extends Drawable implements Movable {

    boolean hit;


    public Target(String fileName) {
        super(fileName);
    }


    public abstract int whenHit();

    @Override
    public void move() {

    }

}
