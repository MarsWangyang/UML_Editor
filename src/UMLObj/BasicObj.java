package UMLObj;

import java.awt.*;

public abstract class BasicObj extends Shape{
    private String name = null;
    private boolean isSelected = false;
    protected double width;
    protected double height;

    public void resetName(String newName) {

    }

    public void setSelected() {

    }

    public void resetLocation(Point delta) {

    }

    public abstract void draw(Graphics g);
}
