package org.academiadecodigo.variachis.arcadeshooter;


import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;


import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private Player player;
    private Target[] createTargets;
    private LinkedList<Target> targetOffStage;
    private LinkedList<Target> targetOnStage;
    private Boolean gameover = false;
    private int numberOfTargets = 20;
    private TargetFactory targetFactory;
    private int currentOnStage = 5;


    public Game() {
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();


    }

    public void init() {

        //Game sets the maximum number of targets to be created on the factory
        targetFactory.setMaxNumberTargets(numberOfTargets);
        //Create all the targets before starting the game
        for (int i = 0; i < createTargets.length; i++) {
            //creates a target
            createTargets[i] = targetFactory.newTarget();
            //add target to off stage
            targetOffStage.add(createTargets[i]);
        }




        /*
        targetOffStage.add(new Foe());
        targetOffStage.add(new Foe());
        targetOffStage.add(new Foe());
        targetOffStage.add(new Foe());
        targetOffStage.add(new Foe());
        targetOffStage.add(new Foe());
        targetOffStage.add(new AmmoBonus());
        targetOffStage.add(new HPBonus());
        targetOffStage.add(new Victim());
        targetOffStage.add(new AmmoBonus());
        targetOffStage.add(new HPBonus());
        targetOffStage.add(new Foe());
        targetOffStage.add(new Victim());
        targetOffStage.add(new Victim());
        targetOffStage.add(new Victim());
        targetOffStage.add(new Victim());
        targetOffStage.add(new AmmoBonus());
        targetOffStage.add(new HPBonus());
        */

    }

    public void setGameover() {

        if (player.checkIfGameover()) {

            this.gameover = true;

            System.out.println("GAME OVER");

        } else
            System.out.println("STILL BULLETS OR HP");


    }

    public void addElementOnStage () {

        while (targetOnStage.size() < currentOnStage) {

            //index of element to remove from off stage
            int elementToRemove = ((int) (Math.random() * (targetOffStage.size())));
            //get target to remove from off stage using the index and add that target to on stage
            targetOnStage.add(targetOffStage.get(elementToRemove));
            System.out.println(targetOnStage);
            //remove target from off stage
            targetOffStage.remove(elementToRemove);
            System.out.println(targetOffStage.size());


        }



    }

    public void removeTargetShot (Target  target) {

        targetOffStage.add(target);
        targetOnStage.remove(targetOnStage.indexOf(target));

    }


    public void play() {

        while (!gameover) {
            //Have always 5 targets on stage
            addElementOnStage();

            for (Target t : targetOnStage) {
                player.shoot(t);
                removeTargetShot(t);
                addElementOnStage();
                setGameover();
                if (gameover) {
                    break;
                }
        /*for (Target t : targetOffStage) {
            player.shoot(t);
            setGameover();
            if (gameover) {
                break;
            }

        */


        /*while (!gameover) {


        }*/
            }

        }

    }
}
