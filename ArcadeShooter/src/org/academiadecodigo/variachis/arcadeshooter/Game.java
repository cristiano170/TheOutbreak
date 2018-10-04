package org.academiadecodigo.variachis.arcadeshooter;


import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;


import java.util.LinkedList;

public class Game {

    private Player player;
    private LinkedList<Target> target;
    private Boolean gameover;


    public Game(){
        player = new Player();
        target = new LinkedList<>();

    }

    public void init(){
        target.add(new Foe());
        target.add(new Victim());
        target.add(new AmmoBonus());
        target.add(new HPBonus());
        target.add(new Foe());
        target.add(new Victim());
        target.add(new AmmoBonus());
        target.add(new HPBonus());

        for (Target t : target){
            player.shoot(t);
        }
    }

    public void setGameover(Boolean gameover) {

        this.gameover = true;

    }

    public void play() {

        /*while (!gameover) {


        }*/
    }


}
