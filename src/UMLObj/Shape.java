package UMLObj;

import java.awt.*;
import UMLEditor.Canvas;

import javax.swing.*;

public abstract class Shape {

    protected Canvas canvas;

    public Shape() {
        canvas = Canvas.getInstance();
    }



    public void resetLocation() {
    }

    public abstract void selectSwitch(Boolean chosen);

    public abstract Dimension getObjSize();

    public abstract Point getInitPoint();

    public abstract void draw(Graphics g);

    public abstract void resetName(String newName);

    public abstract void draggedMovement(Point point);
}
