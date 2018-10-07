package org.academiadecodigo.variachis.arcadeshooter.Drawable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Drawable {

    private String fileName;
    private Picture picture;


    public Drawable(String fileName) throws java.lang.NullPointerException {
        try {
            this.fileName = fileName;
        } catch (NullPointerException e) {
        }
    }

    public void drawTarget() {

        int xRan = (int) (Math.random() * 1000 );
        int yRan = (int) (Math.random() * 550 );

        picture = new Picture(xRan, yRan, fileName);

        picture.draw();

    }

    public void deleteTargetImg() {
        picture.delete();
    }


}
