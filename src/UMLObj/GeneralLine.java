package UMLObj;

import java.awt.*;

public class GeneralLine extends LineObj {
    private int arrowW = 10, arrowH = 10;
    public GeneralLine(Point initPoint, Point endPoint) {
        this.objLeftX = (int) initPoint.getX();
        this.objLeftY = (int) initPoint.getY();
        this.objRightX = (int) endPoint.getX();
        this.objRightY = (int) endPoint.getY();

    }


    @Override
    public void draw(Graphics g) {
        g.drawLine(this.objLeftX, this.objLeftY, this.objRightX, this.objRightY);

        int dx = this.objRightX - this.objLeftX, dy = this.objRightY - this.objLeftY;
        double D = Math.sqrt(dx*dx + dy*dy);

        double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
        double sin = dy/D, cos = dx/D;

        x = xm*cos - ym*sin + this.objLeftX;
        ym = xm*sin + ym*cos + this.objLeftY;
        xm = x;

        x = xn*cos - yn*sin + this.objLeftX;
        yn = xn*sin + yn*cos + this.objLeftY;
        xn = x;

        int[] xpoints = {this.objRightX, (int) xm, (int) xn};
        int[] ypoints = {this.objRightY, (int) ym, (int) yn};

        g.fillPolygon(xpoints, ypoints, 3);
    }
}
