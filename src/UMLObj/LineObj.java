package UMLObj;

import java.awt.*;

public class LineObj extends Shape{
    protected Port[] linePort = new Port[2];
    int objLeftX;
    int objLeftY;
    int objRightX;
    int objRightY;


    public void setLinePort(Port initPort, Port endPort) {
        linePort[0] = initPort;
        linePort[1] = endPort;
    }

    @Override// 可以直接在subclass裡面直接取用
    public void resetLocation() {
        System.out.println(linePort[0].getPort());
        System.out.println(linePort[1].getPort());
        this.objLeftX = (int) linePort[0].getPort().getX();
        this.objLeftY = (int) linePort[0].getPort().getY();
        this.objRightX = (int) linePort[1].getPort().getX();
        this.objRightY = (int) linePort[1].getPort().getY();
    }

    @Override
    public Point getInitPoint() {
        return new Point(0,0);
    }

    @Override
    public void selectSwitch(Boolean chosen) {
        return ;
    }


    @Override
    public void draw(Graphics g) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public Port[] getPortLocation() {
        return new Port[0];
    }
}
