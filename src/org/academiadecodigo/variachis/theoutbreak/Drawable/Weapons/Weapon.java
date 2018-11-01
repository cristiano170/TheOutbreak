package org.academiadecodigo.variachis.theoutbreak.Drawable.Weapons;

import org.academiadecodigo.variachis.theoutbreak.Drawable.Drawable;
import org.academiadecodigo.variachis.theoutbreak.Drawable.Targets.Target;
import org.academiadecodigo.variachis.theoutbreak.Movable;


public class Weapon extends Drawable implements Movable {

    private final int bulletMax = 10;
    private static int currentBullets;

    public Weapon(String fileName) throws java.lang.NullPointerException {
        super(fileName);
        // Sets the initial number of bullets the weapon will have when it's created
        this.currentBullets = bulletMax;
    }

    public int getCurrentBullets() {

        return currentBullets;

    }


    public int getBulletMax() {
        return bulletMax;
    }

    public void setCurrentBullets() {
        this.currentBullets = this.bulletMax;
    }

    public void setCurrentBullets(int ammoBonus) {
        this.currentBullets += ammoBonus;
    }

    public int fire(Target target) {

        // When the weapon is fired if the number of bullets is bigger than zero it will decrement
        // the number of bullets by one

        if (currentBullets > 0) {
            currentBullets--;
        }
        return target.whenHit();  // Returns the specific result that occurs when each target is hit


    }

    public void fire() {

        if (currentBullets > 0) {
            currentBullets--;
            System.out.println(currentBullets);
        }
    }

    @Override
    public void move() {

    }
}
