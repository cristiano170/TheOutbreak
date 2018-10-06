package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons.Weapon;

public class Player {

    private int hp = 3;
    private final int maxHP = 5;
    protected int score = 0;
    private String name;
    private Weapon weapon;


    public Player(String name) {

        this.name = name;
        weapon = new Weapon();

    }

    // Checks if Hp or Ammo is zero, and returns true or false
    public boolean checkIfGameover() {

        if (hp == 0 || this.weapon.getCurrentBullets() == 0) {

            return true;
        }
        return false;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    // Player shoots targets and it updates score, health points and ammo
    public void shoot(Target target) {


        if (target instanceof Foe) { // Increments player's score with a return value
            score += weapon.fire(target);
            System.out.println("Foe hit Score: " + score);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());

        }
        if (target instanceof Victim) {  // Decrements player's Hp with a return value
            hp -= weapon.fire(target);
            System.out.println("Victim hit HP: " + hp);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());

        }
        if (target instanceof HPBonus) {
            if (hp == maxHP) {     // If current Hp is the same as maxHp shoots target but doesn't earn any bonus
                weapon.fire(target);
                System.out.println(weapon.getCurrentBullets());
                return;
            }
            hp += weapon.fire(target);  // // Increments player's Hp  with a return value
            System.out.println("HPBonus hit HP: " + hp);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());


        }
        if (target instanceof AmmoBonus) {

            weapon.setCurrentBullets(weapon.fire(target));  // Receives ammo bonus

            // If the current number of bullets is bigger than the maximum number
            // of bullets then it resets the current number of bullets to the maximum number of bullets
            if (weapon.getCurrentBullets() > weapon.getBulletMax()) {
                weapon.setCurrentBullets();
            }
            System.out.println("AmmoBonus hit Ammo: " + target.whenHit());
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());
        }

        checkIfGameover();


    }
}
