package org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.Target;


public abstract class Weapon extends Drawable {

    private int bulletMax = 10;
    private static int currentBullets;

    public Weapon() {

        this.currentBullets = bulletMax;
    }

    public int getCurrentBullets() {

        return currentBullets;

    }

    public void setCurrentBullets(int ammoBonus) {
        this.currentBullets += ammoBonus;
    }

    public void fire(Target target) {

        if (currentBullets > 0) {

            currentBullets--;
        }

    }


}