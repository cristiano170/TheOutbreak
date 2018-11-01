package org.academiadecodigo.variachis.theoutbreak.Drawable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Drawable {

    private String fileName;
    protected Picture  picture;


    public Drawable(String fileName) throws java.lang.NullPointerException {
        try {
            this.fileName = fileName;
            picture = new Picture(0,0,fileName);
        } catch (NullPointerException e) {
        }
    }

    public double picX(){
        return picture.getX();
    }

    public double picY(){
        return picture.getY();
    }

    public double picWidthX(){
        return picture.getWidth();
    }

    public double picHeightY(){
        return picture.getHeight();
    }

    public void drawTarget(int x, int y) {

        /*int xRan;
        int yRan = 0;

        int aux = (int) (Math.random() * 2);
        int aux2 = (int) (Math.random() * 5);

        switch (aux2) {
            case 1:
                yRan = 20;
                break;
            case 2:
                yRan = 150;
                break;
            case 3:
                yRan = 270;
                break;
            case 4:
                yRan = 390;
                break;
            case 5:
                yRan = 510;
                break;
        }*/


       /* if (aux == 1)
            xRan = 10;
        else xRan = 715;*/


        picture = new Picture(x, y, fileName);

        picture.draw();
    }


    public void deleteTargetImg() {
        picture.delete();
    }


}
