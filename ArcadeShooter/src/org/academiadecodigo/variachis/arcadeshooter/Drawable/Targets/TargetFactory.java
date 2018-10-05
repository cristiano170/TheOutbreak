package org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets;

import org.academiadecodigo.variachis.arcadeshooter.Game;

public class TargetFactory {

    private Target target;
    private int currentNumberOfTargets = 0;
    private int maxNumberTargets;

    //Game sets maximum number of targets
    public void setMaxNumberTargets(int targets) {

        maxNumberTargets = targets;
    }

    //Probability of creating each target
    public Target newTarget() {

            if (this.currentNumberOfTargets < maxNumberTargets * 0.4) {
                this.currentNumberOfTargets++;
                return new Foe();
            }

            if (this.currentNumberOfTargets >= maxNumberTargets * 0.4 && currentNumberOfTargets < maxNumberTargets * 0.8) {
                currentNumberOfTargets++;
                return new Victim();
            }

            if (currentNumberOfTargets >= maxNumberTargets * 0.8 && currentNumberOfTargets < maxNumberTargets * 0.9) {
                currentNumberOfTargets++;
                return new HPBonus();
            }
            currentNumberOfTargets++;
            return new AmmoBonus();




    }

    //Game uses this method to create new target
    public Target getNewTarget() {

        target = newTarget();
        return target;


        //target = newTarget();
        //target.setPos();
        //return target;

    }

}
