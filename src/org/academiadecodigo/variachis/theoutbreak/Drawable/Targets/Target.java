package org.academiadecodigo.variachis.theoutbreak.Drawable.Targets;

import org.academiadecodigo.variachis.theoutbreak.Drawable.Drawable;

public abstract class Target extends Drawable {

    boolean hit;


    public Target(String fileName) {
        super(fileName);
    }


    public abstract int whenHit();



}
