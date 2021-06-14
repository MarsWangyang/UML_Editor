package UMLObj;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCaseObj extends BasicObj{

    public UseCaseObj(Point mouseLocation) {
        this.objName = "Use Case";
        this.width = 150;
        this.height = 80;
        initShapeLoc(mouseLocation);
        createPorts();
    }

    @Override
    public void draw(Graphics g) {
        //System.out.println("UseCaseObj painted");

        Graphics2D g2 = (Graphics2D) g;

        FontMetrics fm = g2.getFontMetrics();
        int textLocX = (int) this.objLeftX + ((int) width - fm.stringWidth(objName)) / 2;
        int textLocY = (int) this.objLeftY + (int) height / 2;

        g2.setPaint(Color.WHITE);
        g2.draw(new Ellipse2D.Double(objLeftX, objLeftY, width, height));
        g2.drawString(objName, textLocX, textLocY);

        if (isSelected == true) {
            for (int i = 0; i < ports.length; i++) {
                ports[i].drawPort(g2);
            }
        }

    }

}
