package UMLObj;

import java.awt.*;

public abstract class BasicObj extends Shape{
    protected String objName = null;
    protected boolean isSelected = false;
    protected double width = 130;
    protected double height = 150;
    protected double mouseLocX;
    protected double mouseLocY;
    protected double objLeftX;
    protected double objLeftY;
    protected int portsNum = 4;

    Port[] ports = new Port[portsNum];

    public void resetName(String newName) {

    }

    public void setSelected() {

    }

    public void resetLocation(Point delta) {

    }

    public void setPortLocation () {
        //0: left, 1: bottom, 2: right, 3: top
        ports[0] = new Port(mouseLocX - width / 2, mouseLocY);
        ports[1] = new Port(mouseLocX, mouseLocY + height / 2);
        ports[2] = new Port(mouseLocX + width / 2, mouseLocY);
        ports[3] = new Port(mouseLocX, mouseLocY - height / 2);
    }


    public abstract void draw(Graphics g);
}
