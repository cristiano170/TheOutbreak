package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;

import java.util.LinkedList;

import static java.lang.Thread.sleep;


public class Game {


    private Player player;
    private Target[] createTargets;
    private LinkedList<Target> targetOffStage;
    private LinkedList<Target> targetOnStage;
    private Boolean gameover = false;
    private final int numberOfTargets = 20;
    private TargetFactory targetFactory;
    private final int maxTargetsOnStage = 5;


    public Game() throws java.lang.NullPointerException {
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();


    }


    public void init() {


        //Create background
        Picture background = new Picture(10, 10, "/image/graveyard.png");
        background.draw();


        //Game sets the maximum number of targets to be created in the TargetFactory
        targetFactory.setMaxNumberTargets(numberOfTargets);


        //Creates all the targets before starting the game
        for (int i = 0; i < createTargets.length; i++) {
            //Creates one target per each iteration
            createTargets[i] = targetFactory.newTarget();
            //Adds target to the targetOffStage list
            targetOffStage.add(createTargets[i]);
        }

    }

    // If checkIfGameover method returns true the game is over, otherwise the game continues
    public void setGameOver() {

        if (player.checkIfGameover()) {

            this.gameover = true;

            System.out.println("GAME OVER");

        } else
            System.out.println("STILL BULLETS OR HP");


    }

    public void addElementOnStage() {

        while (targetOnStage.size() < maxTargetsOnStage) {


            //Gets random index of element to remove from the offStage list
            int elementToRemove = ((int) (Math.random() * (targetOffStage.size())));
            //Gets target to remove from the offStage list using the index and adds that target to the onStage list
            targetOnStage.add(targetOffStage.get(elementToRemove));
            targetOffStage.get(elementToRemove).drawTarget();
            System.out.println(targetOnStage);
            //Removes target from the offStage list
            targetOffStage.remove(elementToRemove);
            System.out.println(targetOffStage.size());


        }


    }


    // When target is hit it's added to the offStage list and then removed from the onStage list
    public void removeTargetShot(Target target) {

        int elementToRemove = targetOnStage.indexOf(target);
        targetOffStage.add(targetOnStage.get(elementToRemove));
        targetOnStage.get(elementToRemove).deleteTargetImg();
        targetOnStage.remove(elementToRemove);

    }


    public void play() throws java.lang.InterruptedException {

        // While game isn't over:
        while (!gameover) {
            // - it always has 5 targets on stage
            addElementOnStage();

            //Running the program in an automatic way
            for (int i = 0; i < targetOnStage.size(); i++) {


                player.shoot(targetOnStage.get(i));
                System.out.println(targetOnStage.get(i));
                targetOnStage.get(i).deleteTargetImg();
                removeTargetShot(targetOnStage.get(i));
                addElementOnStage();

                setGameOver();
                sleep(1000);

                if (gameover) {
                    return;
                }

            }

        }
    }
}
