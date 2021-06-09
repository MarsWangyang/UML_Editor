package UMLObj;

import java.awt.*;
import UMLEditor.Canvas;

public abstract class Shape {
    private String SID = null;
    protected Canvas canvas;

    public Shape() {
        canvas = Canvas.getInstance();
    }

    public abstract void draw(Graphics g);

    public void resetLocation() {

    }





}
