package UMLObj;

import java.awt.*;

public class CompositeLine extends LineObj{
    int diamondW = 10, diamondH = 10;
    public CompositeLine (Point initPoint, Point endPoint) {
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

        int dx = this.objRightX - this.objLeftX;
        int dy = this.objRightY - this.objLeftY;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + this.objLeftX;
        ym = xm*sin + ym*cos + this.objLeftY;
        xm = x;

        x = xn*cos - yn*sin + this.objLeftX;
        yn = xn*sin + yn*cos + this.objLeftY;
        xn = x;


        double xq = (diamondH*2/D)*this.objLeftX + ((D-diamondH*2)/D)*this.objRightX;
        double yq = (diamondH*2/D)*this.objLeftY + ((D-diamondH*2)/D)*this.objRightY;

        int[] xpoints = {this.objRightX, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {this.objRightY, (int) ym, (int) yq, (int) yn};

        g2.fillPolygon(xpoints, ypoints, 4);

        g2.setPaint(Color.white);

    }
}
