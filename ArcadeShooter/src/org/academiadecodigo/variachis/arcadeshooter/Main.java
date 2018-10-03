package org.academiadecodigo.variachis.arcadeshooter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        URL url = Main.class.getResource("/image/video-game-background-animated-GIF-5.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);




        Picture background = new Picture(10, 10, "/image/OldWest.png");
        background.draw();

        /*Picture target1 = new Picture(850, 200, "/image/Target.png");
        target1.grow(-10,10);
        target1.draw();*/

        /*Picture target2 = new Picture(570, 350, "/image/Target.png");
        target2.grow(10,10);
        target2.draw();*/

        Picture bird = new Picture(800, 15, "/image/Bird.png");
        bird.grow(-80,-80);
        bird.draw();

        Picture duck = new Picture(1015, 340, "/image/Duck.png");
        duck.grow(-152,-170);
        duck.draw();
    }
}
