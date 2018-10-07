package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

public class HPBonus extends Target {


    private int hpPoints = 1;


    public HPBonus(String fileName){
        super(fileName);
    }

    // When HPBonus is hit it returns one point to be increased in the player's Hp
    @Override
    public int whenHit() {
        hit = true;
        return hpPoints;
    }


}
