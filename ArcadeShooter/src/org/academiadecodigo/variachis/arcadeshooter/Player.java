package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons.Weapon;

public class Player extends Drawable {

    private int hp = 3;
    private final int maxHP = 5;
    protected int score = 0;
    private String name;
    private Weapon weapon;


    public Player(String name) {

        this.name = name;

    }

    public Player() {
        name = "Rambodias";
        weapon = new Weapon();
    }

    public boolean checkIfGameover() {

        if (hp == 0 || this.weapon.getCurrentBullets() == 0) {

            return true;
        }
        return false;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public void shoot(Target target) {


        if (target instanceof Foe) {
            score += weapon.fire(target);
            System.out.println("Foe hit Score: " + score);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());

        }
        if (target instanceof Victim) {
            hp -= weapon.fire(target);
            System.out.println("Victim hit HP: " + hp);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());

        }
        if (target instanceof HPBonus) {
            if (hp == maxHP) {
                weapon.fire(target);
                System.out.println(weapon.getCurrentBullets());
                return;
            }
            hp += weapon.fire(target);
            System.out.println("HPBonus hit HP: " + hp);
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());


        }


        if (target instanceof AmmoBonus) {

            weapon.setCurrentBullets(weapon.fire(target));


            if (weapon.getCurrentBullets() > weapon.getBulletMax()) {

                weapon.setCurrentBullets();
            }
            System.out.println("AmmoBonus hit Ammo: " + target.whenHit());
            System.out.println("Weapon current ammo: " + weapon.getCurrentBullets());
        }

        checkIfGameover();


    }
}
