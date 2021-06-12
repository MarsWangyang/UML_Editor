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

    public void createPosition(Point mouseLocation) {
        this.mouseLocX = mouseLocation.getX();
        this.mouseLocY = mouseLocation.getY();
        this.objLeftX = this.mouseLocX - (this.width / 2);    //讓滑鼠點擊時，會是在滑鼠中心創建
        this.objLeftY = this.mouseLocY - (this.height / 2);   //讓滑鼠點擊時，會是在滑鼠中心創建
    }

    public void draggedMovement(Point mouseDraggingLoc) {
        createPosition(mouseDraggingLoc);
        setPortLocation();
        canvas.repaint();
    }

    public abstract void draw(Graphics g);
}
