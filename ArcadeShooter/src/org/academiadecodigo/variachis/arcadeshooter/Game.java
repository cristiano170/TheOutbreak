package org.academiadecodigo.variachis.arcadeshooter;


import org.academiadecodigo.simplegraphics.graphics.Text;
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
    private int numberOfTargets = 20;
    private TargetFactory targetFactory;
    private int maxTargetsOnStage = 5;
    Controller controller = new Controller();


    public Game() throws java.lang.NullPointerException {
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();


    }

    public void init() {

        // Create background
        Picture background = new Picture(10, 10, "/image/cemetary.jpg");
        background.draw();

        Controller c = new Controller();
        c.customCursor();

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
            while (true) {
                int xRan = (int) (Math.random() * 1000);
                int yRan = (int) (Math.random() * 550);
                for (int i = 0 ; i < targetOnStage.size() ; i++) {
                    if (xRan > targetOnStage.get(i).picX() - 200
                            && xRan < targetOnStage.get(i).picX() + targetOnStage.get(i).picWidthX() + 200
                        && yRan > targetOnStage.get(i).picY() - 200
                            && yRan <targetOnStage.get(i).picY() + targetOnStage.get(i).picHeightY() + 200)
                    {
                        targetOffStage.get(elementToRemove).drawTarget(xRan,yRan);
                        System.out.println(targetOnStage);
                        //Removes target from the offStage list
                        targetOffStage.remove(elementToRemove);
                        System.out.println(targetOffStage.size());
                        return;
                    }
                }
            }
        }


    }


    // When target is hit it's added to the offStage list and then removed from the onStage list
    public void removeTargetShot(Target target) {

        int elementToRemove = targetOnStage.indexOf(target);
        targetOffStage.add(targetOnStage.get(elementToRemove));
        targetOnStage.remove(elementToRemove).deleteTargetImg();
        //targetOnStage.remove(elementToRemove);

    }


    public void play() throws java.lang.InterruptedException {

        // While game isn't over:
        while (!gameover) {
            // - it always has 5 targets on stage
            addElementOnStage();

            //for (Target t : targetOnStage) {
            //t.deleteTarget();
            //}


//            for (Target t : targetOnStage) {
            for (int i = 0; i < targetOnStage.size(); i++) {


                //for (Target t : targetOnStage) {
                //  t.drawTarget();
                //}
                player.shoot(targetOnStage.get(i));
                System.out.println(targetOnStage.get(i));
                targetOnStage.get(i).deleteTargetImg();
                removeTargetShot(targetOnStage.get(i));
                addElementOnStage();
                Text txt = new Text(500,30, "Score: " + player.getScore() + "-  HP: " + player.getHp());
                txt.grow(55,20);
                txt.draw();
                setGameover();
                sleep(1000);

                if (gameover) {
                    return;
                }
                txt.delete();

                //for (Target t : targetOnStage) {
                //  t.deleteTarget();
                //}

            }


        }
    }
}
