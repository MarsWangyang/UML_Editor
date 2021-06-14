package UMLObj;

import java.awt.*;

public class AssociateLine extends LineObj{


    public AssociateLine(Point initPoint, Point endPoint) {
        this.objLeftX = (int) initPoint.getX();
        this.objLeftY = (int) initPoint.getY();
        this.objRightX = (int) endPoint.getX();
        this.objRightY = (int) endPoint.getY();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
        //g2.setStroke(new BasicStroke(1.0f));

        g2.setColor(Color.WHITE);
        g2.drawLine(this.objLeftX, this.objLeftY, this.objRightX, this.objRightY);
    }
}
