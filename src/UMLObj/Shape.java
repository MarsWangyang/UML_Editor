package UMLObj;

import UMLEditor.Canvas;

import java.awt.*;
import java.util.Vector;

public abstract class Shape {


    protected Boolean isSelected;
    Canvas canvas = Canvas.getInstance();


    public void resetLocation (Point mouseDragLoc) {   //Object Relocate

    }

    public void resetLocation () {      //Line Relocate

    }
    public abstract Point getInitPoint();

    public abstract void selectSwitch(Boolean chosen);

    public abstract void draw(Graphics g);

    public abstract int getWidth();
    public abstract int getHeight();

    public abstract Port[] getPortLocation();


    //public abstract Vector getS();


    //public abstract void draw();
}
