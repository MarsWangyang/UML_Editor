package UMLObj;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ClassObj extends BasicObj{

    public ClassObj (Point mouseLocation) {
        this.objName = "Class";
        initShapeLoc(mouseLocation);
        createPorts();
    }



    public void draw(Graphics g) {
        //System.out.println("ClassObj painted");
        Graphics2D g2 = (Graphics2D) g;

        double firstSepLineLocY = this.objLeftY + 50;
        double secondSepLineLocY = this.objLeftY + 100;

        FontMetrics fm = g2.getFontMetrics();
        int textLocX = (int) this.objLeftX + ((int) width - fm.stringWidth(objName)) / 2;
        int textLocY = (int) this.objLeftY + 30;

        g2.setPaint(Color.WHITE);
        g2.draw(new Rectangle2D.Double(objLeftX, objLeftY, width, height));
        g2.draw(new Line2D.Double(objLeftX, firstSepLineLocY, objLeftX+width, firstSepLineLocY));
        g2.draw(new Line2D.Double(objLeftX, secondSepLineLocY, objLeftX+width, secondSepLineLocY));
        g2.drawString(objName, textLocX, textLocY);


        if (isSelected == true) {
            for (int i = 0; i < ports.length; i++){
                ports[i].drawPort(g2);
            }
        }


    }
}
