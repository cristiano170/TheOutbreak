package org.academiadecodigo.variachis.theoutbreak;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ConcurrentModificationException;

public class Hud {


    private Text scoreText;
    private Text hpText;
    private Text bulletText;


    public Hud() {

        scoreText = new Text(710, 565, "");
        scoreText.grow(18, 18);
        scoreText.setColor(Color.WHITE);

        hpText = new Text(330, 565, "");
        hpText.grow(18, 18);
        hpText.setColor(Color.WHITE);

        bulletText = new Text(480, 565, "");
        bulletText.grow(18, 18);
        bulletText.setColor(Color.WHITE);

    }


    public void setValuesText(Integer score, Integer hp, Integer ammo) {

        try {
            scoreText.setText(score.toString());
            hpText.setText(hp.toString());
            bulletText.setText(ammo.toString());
        }
        catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }

    public void showValues() throws java.util.ConcurrentModificationException {
        try {
            scoreText.draw();
            hpText.draw();
            bulletText.draw();
        }
        catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }


    }

}
