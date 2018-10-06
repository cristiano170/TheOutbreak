package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws java.lang.InterruptedException {


        Game game = new Game();


        game.init();
        game.play();

        /*URL url = Main.class.getResource("/image/video-game-background-animated-GIF-5.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);




        Picture background = new Picture(10, 10, "/image/OldWest.png");
        background.draw();

        Picture target1 = new Picture(850, 200, "/image/bankrobber.png");
        target1.grow(-10,10);
        target1.draw();

        Picture target2 = new Picture(570, 250, "/image/Cowboy.png");
        target2.grow(-60,-80);
        target2.draw();



        Picture bird = new Picture(100, 15, "/image/Bird.png");
        bird.grow(-80, -80);
        bird.draw();

        for (int i = 1 ; i < 800 ; i++) {
            bird.translate(1, 0);
            bird.draw();
            sleep(10);
        }


        Picture duck = new Picture(1015, 340, "/image/Duck.png");
        duck.grow(-152,-170);
        duck.draw();*/
    }
}
