package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.*;

import java.util.LinkedList;

import static java.lang.Thread.sleep;


public class Game implements KeyboardHandler, MouseHandler {

    private boolean gameStart = false;
    private boolean gameEnd = false;
    private Player player;
    private Target[] createTargets;
    private LinkedList<Target> targetOffStage;
    private LinkedList<Target> targetOnStage;
    private Boolean gameover = false;
    private final int numberOfTargets = 20;
    private TargetFactory targetFactory;
    private final int maxTargetsOnStage = 5;
    private Picture gamepic;
    private Picture crosshair;
    //private Picture gamepic;


    public Game() throws java.lang.NullPointerException {
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();


    }


    public void init() throws InterruptedException {


        //Create gamepic
        gamepic = new Picture(10, 10, "/image/Main Menu.png");
        //gamepic = new Picture(10, 10, "/image/graveyard.png");

        gamepic.draw();


        //Game sets the maximum number of targets to be created in the TargetFactory
        targetFactory.setMaxNumberTargets(numberOfTargets);


        //Creates all the targets before starting the game
        for (int i = 0; i < createTargets.length; i++) {
            //Creates one target per each iteration
            createTargets[i] = targetFactory.newTarget();
            //Adds target to the targetOffStage list
            targetOffStage.add(createTargets[i]);
        }


        Keyboard k = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();

        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(space);


        while (!gameStart) {
            System.out.println();
        }


        play();


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                gameStart = true;
                break;
            case KeyboardEvent.KEY_E:
                gameEnd = true;
                break;


            default:
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    // If checkIfGameover method returns true the game is over, otherwise the game continues
    public void setGameOver() {

        if (player.checkIfGameover()) {

            this.gameover = true;
            for (Target t : targetOnStage) {
                t.deleteTargetImg();
                Picture gameover = new Picture(gamepic.getWidth() / 4, gamepic.getHeight() / 4, "image/gameover.png");
                gameover.draw();



            }

            System.out.println("GAME OVER");

        }


    }

    public void addElementOnStage() {

        while (targetOnStage.size() < maxTargetsOnStage) {

            //Gets random index of element to remove from the offStage list
            int elementToRemove = ((int) (Math.random() * (targetOffStage.size())));
            //Gets target to remove from the offStage list using the index and adds that target to the onStage list
            targetOnStage.add(targetOffStage.get(elementToRemove));

            int xRan = (int) (Math.random() * (gamepic.getWidth() - 100));
            int yRan = (int) (Math.random() * (gamepic.getHeight() - 200));

            while (checkColision(xRan, yRan)) {
                xRan = (int) (Math.random() * (gamepic.getWidth() - 100));
                yRan = (int) (Math.random() * (gamepic.getHeight() - 200));
            }


            targetOffStage.get(elementToRemove).drawTarget(xRan, yRan);
            //System.out.println(targetOnStage);
            //Removes target from the offStage list
            targetOffStage.remove(elementToRemove);
            //System.out.println(targetOffStage.size());

        }


    }


    // When target is hit it's added to the offStage list and then removed from the onStage list
    private void removeTargetShot(Target target) {

        int elementToRemove = targetOnStage.indexOf(target);
        targetOffStage.add(targetOnStage.get(elementToRemove));
        targetOnStage.get(elementToRemove).deleteTargetImg();
        targetOnStage.remove(elementToRemove);

    }


    private void play() throws java.lang.InterruptedException {

        gamepic.delete();
        gamepic = new Picture(10, 10, "image/graveyard.jpg");
        gamepic.draw();

        System.out.println("LOADED");


        System.out.println("PLAY");

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        // gamepic.delete();
        //  gamepic = new Picture(10, 10, "/image/graveyard.jpg");
        // gamepic.draw();
        //gamepic.delete();
        crosshair = new Picture(10, 10, "/image/crosshair.png");
        //crosshair.draw();
        // While game isn't over:


        while (!gameover) {

            // - it always has 5 targets on stage
            addElementOnStage();

            //Running the program in an automatic way
            /*for (int i = 0; i < targetOnStage.size(); i++) {


                player.shoot(targetOnStage.get(i));
                System.out.println(targetOnStage.get(i));
                targetOnStage.get(i).deleteTargetImg();
                removeTargetShot(targetOnStage.get(i));
                addElementOnStage();
*/
          /*  Text scoreText = new Text(650, 565, "" + player.getScore());
            Text hpText = new Text(100, 565, "" + player.getHp());
            Text bulletText = new Text(375, 565, "" + player.getWeaponBullets());
            scoreText.draw();
            hpText.draw();
            bulletText.draw();*/


            setGameOver();



            if (gameover) {


                return;

            }
            /*scoreText.delete();
            hpText.delete();
            bulletText.delete();*/

            Keyboard k = new Keyboard(this);
            KeyboardEvent space = new KeyboardEvent();

            space.setKey(KeyboardEvent.KEY_E);
            space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            k.addEventListener(space);

            while(!gameEnd) {

                gameStart = false;
                System.out.println();

            }

            init();
        }


    }

    public void moveTheMouse(double x, double y, String s) {

        crosshair.delete();
        crosshair = new Picture(x, y, s);
        if (x < (gamepic.getWidth() - crosshair.getWidth()) && y < gamepic.getHeight() - crosshair.getHeight()) {
            crosshair.translate(-10, -40);
            crosshair.draw();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        switch (mouseEvent.getEventType()) {
            case MOUSE_CLICKED:
                Target targetHit = checkTargetHit(crosshair.getX() + (crosshair.getWidth() / 2d), crosshair.getY() +
                        (crosshair.getHeight() / 2d));
                if (targetHit != null) {
                    player.shoot(targetHit);
                    targetHit.deleteTargetImg();
                    removeTargetShot(targetHit);
                    addElementOnStage();
                    setGameOver();


                }


        }

    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        moveTheMouse(mouseEvent.getX(), mouseEvent.getY(), "/image/crosshair.png");
    }

    public Target checkTargetHit(double x, double y) {

        for (int i = 0; i < targetOnStage.size(); i++) {
            if (x > targetOnStage.get(i).picX()
                    && x < targetOnStage.get(i).picX() + targetOnStage.get(i).picWidthX()
                    && y > targetOnStage.get(i).picY()
                    && y < targetOnStage.get(i).picY() + targetOnStage.get(i).picHeightY()) {

                return targetOnStage.get(i);
            }
        }
        return null;

    }

    public boolean checkColision(int xRan, int yRan) {

        /*for (int i = 0; i < targetOnStage.size(); i++) {
            if (xRan > targetOnStage.get(i).picX() - 100
                    && xRan < targetOnStage.get(i).picX() + targetOnStage.get(i).picWidthX() + 100
                    && yRan > targetOnStage.get(i).picY() - 100
                    && yRan < targetOnStage.get(i).picY() + targetOnStage.get(i).picHeightY() + 100) {

                return true;
            }
        }*/

        for (Target t : targetOnStage) {
            if (xRan > t.picX() - 100
                    && xRan < t.picX() + t.picWidthX() + 100
                    && yRan > t.picY() - 100
                    && yRan < t.picY() + t.picHeightY() + 100) {

                return true;

            }
        }
        return false;
    }
}
