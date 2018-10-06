package org.academiadecodigo.variachis.arcadeshooter;


import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;


import java.util.LinkedList;

public class Game {

    private Player player;
    private Target[] createTargets;
    private LinkedList<Target> targetOffStage;
    private LinkedList<Target> targetOnStage;
    private Boolean gameover = false;
    private int numberOfTargets = 20;
    private TargetFactory targetFactory;
    private int maxTargetsOnStage = 5;


    public Game() {
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();


    }

    public void init() {

        //Game sets the maximum number of targets to be created in the TargetFactory
        targetFactory.setMaxNumberTargets(numberOfTargets);
        //Creates all the targets before starting the game
        for (int i = 0; i < createTargets.length; i++) {
            //Creates one target per each iteration
            createTargets[i] = targetFactory.newTarget();
            //Adds target to the targetOffStage list
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

    // If checkIfGameover method returns true the game is over, otherwise the game continues
    public void setGameover() {

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
        targetOnStage.remove(elementToRemove);


    }


    public void play() {

        // While game isn't over:
        while (!gameover) {
            // - it always has 5 targets on stage
            addElementOnStage();

//            for (Target t : targetOnStage) {
            for (int i = 0; i < targetOnStage.size(); i++) {
                player.shoot(targetOnStage.get(i));
                removeTargetShot(targetOnStage.get(i));
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
                // }

            }

        }
    }
}
