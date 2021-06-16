package UMLObj;

import java.awt.*;

public class BasicObj extends Shape{
    protected String objName = null;
    protected Port[] ports = new Port[4];
    protected boolean isSelected = false;
    public double width = 130;
    public double height = 150;
    protected double mouseLocX;
    protected double mouseLocY;
    protected double objLeftX;
    protected double objLeftY;

    public void resetName(String newName) {
        this.objName = newName;
        canvas.repaint();
    }

    public Point getInitPoint(){
        return new Point((int)objLeftX, (int)objLeftY);
    }

    public void selectSwitch(Boolean chosen) {
        this.isSelected = chosen;
    }


    public int getObjLeftX() {
        return (int) objLeftX;
    }

    public int getObjLeftY() {
        return (int) objLeftY;
    }


    public int getWidth() {
        return (int) width;
    }


    public int getHeight() {
        return (int) height;
    }

    //初始化object位置
    public void initShapeLoc(Point mouseLocation) {
        this.mouseLocX = mouseLocation.getX();
        this.mouseLocY = mouseLocation.getY();
        this.objLeftX = this.mouseLocX;
        this.objLeftY = this.mouseLocY;

    }

    public Port[] getPortLocation() {
        return ports;
    }

    @Override
    public void resetLocation(Point delta) {

        this.objLeftX = this.objLeftX + delta.getX();
        this.objLeftY = this.objLeftY + delta.getY();


        //When basic object was dragged, ports will automatically relocate the position
        //and remind that the lines connected with the port need to be relocated.
        ports[0].setPort((int) this.objLeftX, (int) (this.objLeftY+height/2));//重新更新Object Port的位置
        ports[0].resetLineLoc();//port上有連著的線段也要去relocate

        ports[1].setPort((int) (this.objLeftX+width/2), (int) (this.objLeftY+height));
        ports[1].resetLineLoc();

        ports[2].setPort((int) (this.objLeftX+width), (int) (this.objLeftY+height/2));
        ports[2].resetLineLoc();

        ports[3].setPort((int) (this.objLeftX+width/2), (int) (this.objLeftY));
        ports[3].resetLineLoc();


    }

    @Override
    public void draw(Graphics g) {

    }

    public void createPorts() {
        Port port0 = new Port();
        Port port1 = new Port();
        Port port2 = new Port();
        Port port3 = new Port();

        port0.setPort((int) this.objLeftX, (int) (this.objLeftY + height/2));
        ports[0] = port0;

        port1.setPort((int) (this.objLeftX+width/2), (int) (this.objLeftY + height));
        ports[1] = port1;

        port2.setPort((int) (this.objLeftX+width), (int) (this.objLeftY + height/2));
        ports[2] = port2;

        port3.setPort((int) (this.objLeftX+width/2), (int) (this.objLeftY));
        ports[3] = port3;
    }



}
