package org.academiadecodigo.variachis.theoutbreak.Drawable.Targets;

public class TargetFactory {

    private org.academiadecodigo.variachis.theoutbreak.Drawable.Targets.Target target;
    private int currentNumberOfTargets = 0;
    private int maxNumberTargets;

    // Game sets the maximum number of targets
    public void setMaxNumberTargets(int targets) {

        maxNumberTargets = targets;
    }

    // Creation of the 20 initial targets (5 friends, 9 foes, 3 ammo, 3 Hp) in the offStage list
    public Target newTarget() {

        if (this.currentNumberOfTargets < maxNumberTargets * 0.45) {
            this.currentNumberOfTargets++;
            return new Foe("resources/image/Zombie.png");
        }

        if (this.currentNumberOfTargets >= maxNumberTargets * 0.45 && currentNumberOfTargets < maxNumberTargets * 0.7) {
            currentNumberOfTargets++;
            return new Victim("resources/image/cat.png");
        }

        if (currentNumberOfTargets >= maxNumberTargets * 0.7 && currentNumberOfTargets < maxNumberTargets * 0.85) {
            currentNumberOfTargets++;
            return new HPBonus("resources/image/tuna.png");
        }
        currentNumberOfTargets++;
        return new AmmoBonus("resources/image/AmmoB.png");


    }



}
