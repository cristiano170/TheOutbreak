package org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;
import org.academiadecodigo.variachis.arcadeshooter.Game;


public class Weapon extends Drawable {

    private final int bulletMax = 10;
    private static int currentBullets;

    public Weapon() {

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


        if (currentBullets > 0) {

            currentBullets--;
        }
        return target.whenHit();


        /*if (target instanceof Foe) {
            return target.whenHit();
            //System.out.println("Foe hit Score: " + score);
        }
        if (target instanceof Victim) {
            return target.whenHit();
            //System.out.println("Victim hit HP: " + hp);
        }
        if (target instanceof HPBonus) {
            return target.whenHit();
            //System.out.println("HPBonus hit HP: " + hp);
        }

        if (target instanceof AmmoBonus) {
            currentBullets += target.whenHit();
            System.out.println("AmmoBonus hit Ammo: " + getCurrentBullets());
        }*/

    }


}
