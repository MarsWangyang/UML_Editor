package UMLMode;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode{

    public void mouseClicked(MouseEvent e) {
        selectDetection(e.getPoint());
    }

    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragging");
    }

    //根據點擊的位置，去看Shape的Vector中有沒有此元件
    public void selectDetection (Point e) {

        for (int i = canvas.getAllObject().size() - 1; i >= 0; i--) {
            //Init X,Y of each object
            int initX = (int) canvas.getAllObject().elementAt(i).getInitPoint().getX();
            int initY = (int) canvas.getAllObject().elementAt(i).getInitPoint().getY();
            int width = (int) canvas.getAllObject().elementAt(i).getObjSize().getWidth();
            int height = (int) canvas.getAllObject().elementAt(i).getObjSize().getHeight();

            if (e.getX() >= initX &&
                    e.getX() <= (initX + width) &&
                    e.getY() >= initY &&
                    e.getY() <= (initY + height)
            ) {
                canvas.setSelectedShape(canvas.getAllObject().elementAt(i));
                System.out.println("-----" + canvas.getAllObject().elementAt(i) + "-----");
                return ;
            }

        }
        System.out.println("Out of here");
        canvas.setSelectedShape(null);
    }
}
