package org.academiadecodigo.variachis.arcadeshooter.Drawable;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.variachis.arcadeshooter.Drawable.Targets.Target;

import java.util.LinkedList;

public abstract class Drawable {

    private String fileName;
    private Picture picture;


    public Drawable(String fileName) throws java.lang.NullPointerException {
        try {
            this.fileName = fileName;
            picture = new Picture(0,0,fileName);
        } catch (NullPointerException e) {
        }
    }

    public int picX(){
        return picture.getX();
    }

    public int picY(){
        return picture.getY();
    }

    public int picWidthX(){
        return picture.getWidth();
    }

    public int picHeightY(){
        return picture.getHeight();
    }

    public void drawTarget(int x, int y) {

        picture = new Picture(x, y, fileName);

        picture.draw();

    }

    public void deleteTargetImg() {
        picture.delete();
    }


}
