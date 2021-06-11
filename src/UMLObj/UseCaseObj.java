package UMLObj;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class UseCaseObj extends BasicObj{


    public UseCaseObj(Point mouseLocation) {
        this.objName = "Use Case";
        this.width = 150;
        this.height = 80;
        this.mouseLocX = mouseLocation.getX();
        this.mouseLocY = mouseLocation.getY();
        this.objLeftX = this.mouseLocX - (this.width / 2);    //讓滑鼠點擊時，會是在滑鼠中心創建
        this.objLeftY = this.mouseLocY - (this.height / 2);   //讓滑鼠點擊時，會是在滑鼠中心創建
        setPortLocation();
    }

    @Override
    public void resetName(String newName) {
        this.objName = newName;
    }


    //bad
    @Override
    public void selectSwitch(Boolean chosen) {
        this.isSelected = chosen;
    }

    @Override
    public Dimension getObjSize() {
        return new Dimension((int) this.width, (int) this.height);
    }

    @Override
    public Point getInitPoint() {
        return new Point((int) this.objLeftX, (int) this.objLeftY);
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
            for (int i = 0; i < portsNum; i++) {
                ports[i].drawPort(g2);
            }
        }

    }
}
