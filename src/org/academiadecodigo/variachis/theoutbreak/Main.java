package org.academiadecodigo.variachis.theoutbreak;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args)  {


        Game game = new Game();


       // boolean playingGame = true;

        /*while(playingGame){

            game.init();
            System.out.println("main 0");
            game.gameRestart();
            System.out.println("main");


        }*/

        try {
            game.init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //game.play();



    }
}
