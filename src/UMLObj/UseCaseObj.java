package UMLObj;

import java.awt.*;

public class UseCaseObj extends BasicObj{
    private double mouseLocX;
    private double mouseLocY;

    public UseCaseObj(Point mouseLocation) {
        this.mouseLocX = mouseLocation.getX();
        this.mouseLocY = mouseLocation.getY();
    }

    public void draw(Graphics g) {

    }
}
