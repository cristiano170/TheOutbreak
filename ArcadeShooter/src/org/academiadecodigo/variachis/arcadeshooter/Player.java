package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons.Shotgun;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons.Weapon;

public class Player extends Drawable {

    private int hp = 3;
    protected int score = 0;
    private String name;
    private Weapon weapon;


    public Player(String name) {

        this.name = name;

    }

    public Player() {
        name = "Rambodias";
        weapon = new Shotgun();
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public void shoot(Target target) {

        if (target instanceof Foe) {
            score += target.whenHit();
            System.out.println("Foe hit Score: " + score);
        }
        if (target instanceof Victim) {
            hp -= target.whenHit();
            System.out.println("Victim hit HP: " + hp);
        }
        if (target instanceof HPBonus) {
            hp += target.whenHit();
            System.out.println("HPBonus hit HP: " + hp);
        }

        if (target instanceof AmmoBonus) {
            weapon.setCurrentBullets(target.whenHit());
            System.out.println("AmmoBonus hit Ammo: " + weapon.getCurrentBullets());
        }
        weapon.fire(target);
    }


    //TODO: Shoot everithing
}
