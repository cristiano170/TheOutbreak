package org.academiadecodigo.variachis.arcadeshooter;

import javax.tools.Tool;
import java.awt.*;

public class Controller {

    public void customCursor(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("/image/crosshair.png");
        Point point = new Point(24,24);
        Cursor cursor = toolkit.createCustomCursor(img,point, "Crosshair");


    }
}
