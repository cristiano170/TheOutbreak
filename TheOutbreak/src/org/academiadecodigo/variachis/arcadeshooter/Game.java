package org.academiadecodigo.variachis.arcadeshooter;

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
    private Picture gameoverPic;
    private Hud hud;
    private Sound gunShot;
    private Sound introSound;
    private Sound zombieSound;


    public Game() throws java.lang.NullPointerException {
        //Create gamepic
        gamepic = new Picture(10, 10, "/image/Main Menu.png");
        player = new Player("NOME");
        createTargets = new Target[numberOfTargets];
        targetOffStage = new LinkedList<>();
        targetOnStage = new LinkedList<>();
        targetFactory = new TargetFactory();
        hud = new Hud();
        hud.setValuesText(player.getScore(), player.getHp(), player.getWeaponBullets());
        gunShot = new Sound("/resources/sound/gunshot.wav"); // open stream
        introSound = new Sound("/resources/sound/introsong.wav");
        zombieSound = new Sound("/resources/sound/zombiesound.wav");
    }


    public void init() throws InterruptedException {

        gameEnd = false;


        //gamepic = new Picture(10, 10, "/image/graveyard.png");

        gamepic.draw();
        introSound.play(true);


        gameoverPic = new Picture(gamepic.getWidth() / 4.5, 10, "image/gameover.png");
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

        try {
            //introSound.stop();
            play();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                gameStart = true;
                break;
            case KeyboardEvent.KEY_E:
                gameEnd = true;
                System.exit(0);
                break;


            default:
                System.out.println("Invalid KeyStroke");
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
            this.gameEnd = true;

            for (Target t : targetOnStage) {
                t.deleteTargetImg();


            }
            gameoverPic.draw();
            System.out.println("GAME OVER");
            try {
                play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    public void addElementOnStage() {


        while (targetOnStage.size() < maxTargetsOnStage) {

            //Gets random index of element to remove from the offStage list
            int elementToRemove = ((int) (Math.random() * (targetOffStage.size())));
            //Gets target to remove from the offStage list using the index and adds that target to the onStage list
            targetOnStage
                    .add(targetOffStage.
                            get(elementToRemove));


            int xRan = (int) (Math.random() * (((gamepic.getWidth() - 100) - 20) + 1) + 20);
            int yRan = (int) (Math.random() * (((gamepic.getHeight() - 275) - 20) + 1) + 20);

            while (checkColision(xRan, yRan)) {
                xRan = (int) (Math.random() * (((gamepic.getWidth() - 100) - 20) + 1) + 20);
                yRan = (int) (Math.random() * (((gamepic.getHeight() - 275) - 20) + 1) + 20);
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


    public void play() throws java.lang.InterruptedException {


        if (!gameover) {

            zombieSound.play(true);
            gamepic.delete();
            gamepic = new Picture(10, 10, "image/gameField.jpg");
            gamepic.draw();

            System.out.println("LOADED");


            System.out.println("PLAY");

            Mouse m = new Mouse(this);
            m.addEventListener(MouseEventType.MOUSE_CLICKED);
            m.addEventListener(MouseEventType.MOUSE_MOVED);


            crosshair = new Picture(10, 10, "/image/crosshair.png");


            while (!gameover) {

                // - it always has 5 targets on stage
                addElementOnStage();

                //Thread.sleep(10);

                moveTargets();

                Thread.sleep(100);
                hud.showValues();

                setGameOver();
                hud.setValuesText(player.getScore(), player.getHp(), player.getWeaponBullets());



                if (gameover) {
                    hud.showValues();
                    return;
                }

            }
        }

        Keyboard k = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();

        space.setKey(KeyboardEvent.KEY_E);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(space);

        System.out.println("end");


    }

    private void moveTargets() throws java.lang.InterruptedException {

        for (int i = 0; i < targetOnStage.size(); i++) {
            if (targetOnStage.get(i) instanceof Foe || targetOnStage.get(i) instanceof Victim) {
                ((Movable) targetOnStage.get(i)).move();
                Thread.sleep(60);
            }

        }


    }


    private void moveTheMouse(double x, double y, String s) {

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
                //System.out.println("SHOOT");
                Target targetHit = checkTargetHit(crosshair.getX() + (crosshair.getWidth() / 2d), crosshair.getY() +
                        (crosshair.getHeight() / 2d));
                gunShot.play(true);

                if (targetHit != null) {
                    player.shoot(targetHit);
                    removeTargetShot(targetHit);
                }
                if (targetHit == null) {
                    player.shoot();
                }

        }

    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        moveTheMouse(mouseEvent.getX(), mouseEvent.getY(), "/image/crosshair.png");
    }

    private Target checkTargetHit(double x, double y) {

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

    private boolean checkColision(int xRan, int yRan) {


        for (int i = 0; i < targetOnStage.size(); i++) {
            if (xRan > targetOnStage.get(i).picX() - 100
                    && xRan < targetOnStage.get(i).picX() + targetOnStage.get(i).picWidthX() + 100
                    && yRan > targetOnStage.get(i).picY() - 100
                    && yRan < targetOnStage.get(i).picY() + targetOnStage.get(i).picHeightY() + 100) {

                return true;

            }
        }
        return false;
    }
}
