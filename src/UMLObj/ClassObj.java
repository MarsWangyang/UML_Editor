package UMLObj;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ClassObj extends BasicObj{
    double width = 100;
    double height = 140;
    private double mouseLocX;
    private double mouseLocY;
    private double objLeftX;
    private double objLeftY;

    public ClassObj(Point mouseLocation) {
        this.mouseLocX = mouseLocation.getX();
        this.mouseLocY = mouseLocation.getY();
        this.objLeftX = this.mouseLocX - (width / 2);    //讓滑鼠點擊時，會是在滑鼠中心創建
        this.objLeftY = this.mouseLocY - (height / 2);   //讓滑鼠點擊時，會是在滑鼠中心創建
    }



    public void draw(Graphics g) {
        System.out.println("ClassObj painted");

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.WHITE);
        g2.draw(new Rectangle2D.Double(objLeftX, objLeftY, width, height));
        System.out.println(objLeftX);
    }
}
