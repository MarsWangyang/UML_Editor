package UMLMode;

import UMLObj.BasicObj;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode{
    private Point startP = null;

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("---Select Mode Click---");

        clickDetection(e.getPoint());
        canvas.rectPointInitX = 0;
        canvas.rectPointInitY = 0;
        canvas.rectPointEndX = 0;
        canvas.rectPointEndY = 0;
        //canvas.setSelectedShapeVectorFalse();
        //if (canvas.selectedShapeVector.size() != 0) {
        //    canvas.selectedShapeVector.clear();
        //}
        canvas.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("---Select Mode Press---");
        startP = e.getPoint();

        clickDetection(e.getPoint());

        canvas.rectPointInitX = e.getX();
        canvas.rectPointInitY = e.getY();
        canvas.rectPointEndX = e.getX();
        canvas.rectPointEndY = e.getY();
        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("---Select Mode Drag---");
        int moveX = e.getX() - startP.x;  //?N?Odx, dy
        int moveY = e.getY() - startP.y;
        Point move = new Point(moveX, moveY);

        if (canvas.selectedShape != null) {

            canvas.selectedShape.resetLocation(move);
            //updateLine();
            canvas.setTopObject(canvas.selectedShape);
            //System.out.println(canvas.selectedShape.getInitPoint());
            System.out.println("Dragging with Shape");
            startP.x = e.getX();
            startP.y = e.getY();
        }
        canvas.repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("---Select Mode Release---");

    }



    //根據mouseclick的位置，去看Shape的Vector中有沒有此元件
    public void clickDetection(Point e) {
        //這裡會去選取最上層的(最後被加入的)Object
        for (int i = canvas.getAllObject().size() - 1; i >= 0; i--) {
            //Init X,Y of each object
            int initX = (int) canvas.getAllObject().elementAt(i).getInitPoint().getX();
            int initY = (int) canvas.getAllObject().elementAt(i).getInitPoint().getY();
            int width = (int) ((BasicObj) canvas.getAllObject().elementAt(i)).width;
            int height = (int) ((BasicObj) canvas.getAllObject().elementAt(i)).height;

            if (e.getX() >= initX &&
                    e.getX() <= (initX + width) &&
                    e.getY() >= initY &&
                    e.getY() <= (initY + height)
            ) {
                canvas.setSelectedShape(canvas.getAllObject().elementAt(i));
                return ;
            }

        }
        System.out.println("Out of here");
        canvas.setSelectedShape(null);
        //canvas.setSelectedShapeVector(null);

    }
}
