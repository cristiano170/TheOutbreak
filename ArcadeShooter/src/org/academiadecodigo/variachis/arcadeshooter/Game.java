package org.academiadecodigo.variachis.arcadeshooter;


import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;


import java.util.LinkedList;

public class Game {

    private Player player;
    private LinkedList<Target> target;
    private Boolean gameover = false;


    public Game() {
        player = new Player();
        target = new LinkedList<>();


    }


    public void init() {
        target.add(new Foe());
        target.add(new Foe());
        target.add(new Foe());
        target.add(new Foe());
        target.add(new Foe());
        target.add(new Foe());

        target.add(new AmmoBonus());
        target.add(new HPBonus());


        /*target.add(new Victim());
        target.add(new AmmoBonus());
        target.add(new HPBonus());
        target.add(new Foe());
        target.add(new Victim());
        target.add(new Victim());
        target.add(new Victim());
        target.add(new Victim());
        target.add(new AmmoBonus());
        target.add(new HPBonus());*/

        for (Target t : target) {
            player.shoot(t);
            setGameover();
            if (gameover) {
                break;
            }

        }
    }

    public void setGameover() {

        if (player.checkIfGameover()) {

            this.gameover = true;

            System.out.println("GAME OVER");

        } else
            System.out.println("STILL BULLETS OR HP");


    }

    public void play() {

        /*while (!gameover) {


        }*/
    }


}
