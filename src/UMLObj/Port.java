package UMLObj;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

public class Port {
    private int portX;
    private int portY;
    private final int portHeight = 10;
    private final int portWidth = 10;
    protected Vector<LineObj> lineObjVector = new Vector();


    //當要設定port的時候，直接丟兩個座標進來就可以，不應該直接定死constructor
    //會造成一開始物件就被定死位置
    public void setPort(int portX, int portY) {
        this.portX = portX;
        this.portY = portY;
    }

    public void drawPort(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        g2.fill(new Rectangle2D.Double(portX - portWidth / 2, portY - portHeight / 2, portWidth, portHeight));
        for(int i = 0; i < lineObjVector.size(); i++) {
            lineObjVector.elementAt(i).draw(g2);
        }
    }

    public Point getPort() {
        return new Point(portX, portY);
    }


    //每一個port裡面都會有很多條線，這邊是為了要記住線，會在mouseReleased時add
    public void addLine(LineObj line) {
        this.lineObjVector.add(line);
        System.out.println("NOW PORT LINE:" + lineObjVector);
    }

    public void resetLineLoc() {
        for (int i = 0; i < lineObjVector.size(); i++) {
            LineObj line = lineObjVector.elementAt(i);
            System.out.println(line);
            line.resetLocation();
        }
    }

}
