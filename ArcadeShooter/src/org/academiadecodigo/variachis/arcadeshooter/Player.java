package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.variachis.arcadeshooter.Drawable.Drawable;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Weapons.Weapon;

public class Player extends Drawable {

    private int hp = 3;
    protected int score = 0;
    private String name;
    private Weapon weapon;


    public Player(String name) {

        this.name = name;

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void shoot(Target target) {

        if (target instanceof Foe) {
            score += target.whenHit();
        }
        if (target instanceof Victim) {
            hp -= target.whenHit();
        }
        if (target instanceof HPBonus) {
            hp += target.whenHit();
        }

        if (target instanceof AmmoBonus) {
            weapon.setCurrentBullets(target.whenHit());
        }

        weapon.shoot(target);
    }


    //TODO: Shoot everithing
}
