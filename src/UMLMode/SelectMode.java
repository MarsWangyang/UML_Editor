package UMLMode;

import UMLObj.BasicObj;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode{
    private Point startP = null;
    int px;
    int py;
    int pw;
    int ph;

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("---Select Mode Click---");

        clickDetection(e.getPoint());
        canvas.rectPointInitX = 0;
        canvas.rectPointInitY = 0;
        canvas.rectPointEndX = 0;
        canvas.rectPointEndY = 0;
        System.out.println("canvas.selectedShapeVector: " +canvas.selectedShape);
        canvas.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("---Select Mode Press---");
        startP = e.getPoint();
        canvas.setSelectedShapeVectorFalse();
        if (canvas.selectedShapeVector.size() != 0) {
            canvas.selectedShapeVector.clear();
        }
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
        int moveX = e.getX() - startP.x;
        int moveY = e.getY() - startP.y;
        Point move = new Point(moveX, moveY);

        if (canvas.selectedShape != null) {

            canvas.selectedShape.resetLocation(move);
            canvas.setTopObject(canvas.selectedShape);
            //System.out.println(canvas.selectedShape.getInitPoint());
            System.out.println("Dragging with Shape");
            startP.x = e.getX();
            startP.y = e.getY();
        }
        else {
            canvas.rectPointEndX = e.getX();
            canvas.rectPointEndY = e.getY();
            canvas.setSelectedShapeVectorFalse();
            if (canvas.selectedShapeVector.size() != 0) {
                canvas.selectedShapeVector.removeAllElements();
            }
            perfectRect(canvas.rectPointInitX, canvas.rectPointInitY, canvas.rectPointEndX, canvas.rectPointEndY);
            draggedDetection();
        }
        canvas.repaint();

    }

    //放開就把選取方框dispose掉
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("---Select Mode Released---");
        canvas.rectPointInitX = 0;
        canvas.rectPointInitY = 0;
        canvas.rectPointEndX = 0;
        canvas.rectPointEndY = 0;
        //System.out.println(canvas.selectedShapeVector);
        canvas.repaint();
    }


    //根據mouseclick的位置，去看Shape的Vector中有沒有此元件
    public void clickDetection(Point e) {
        //這裡會去選取最上層的(最後被加入的)Object
        for (int i = canvas.getAllObject().size() - 1; i >= 0; i--) {
            //Init X,Y of each object
            int initX = (int) canvas.getAllObject().elementAt(i).getInitPoint().getX();
            int initY = (int) canvas.getAllObject().elementAt(i).getInitPoint().getY();
            int width =  canvas.getAllObject().elementAt(i).getWidth();
            int height = canvas.getAllObject().elementAt(i).getHeight();

            if (e.getX() >= initX &&
                    e.getX() <= (initX + width) &&
                    e.getY() >= initY &&
                    e.getY() <= (initY + height)
            ) {

                canvas.setSelectedShape(canvas.getAllObject().elementAt(i));
                return ;
            }

        }
        //canvas.setSelectedShapeFalse();
        canvas.setSelectedShape(null);

        //canvas.setSelectedShapeVector(null);

    }

    public void perfectRect(int x, int y, int x2, int y2) {
        this.px = Math.min(x,x2);
        this.py = Math.min(y,y2);
        this.pw = Math.abs(x-x2);
        this.ph = Math.abs(y-y2);
    }

    public void draggedDetection() {
        //System.out.println("$$$$$$$$$$$$$");
        for (int i = 0; i < canvas.getAllObject().size(); i++) {
            int initX = (int) canvas.getAllObject().elementAt(i).getInitPoint().getX();
            int initY = (int) canvas.getAllObject().elementAt(i).getInitPoint().getY();
            int width =  canvas.getAllObject().elementAt(i).getWidth();
            int height =  canvas.getAllObject().elementAt(i).getHeight();


            if (px <= initX &&
                    py <= initY &&
                    initX + width <= px + pw &&
                    initY + height <= py + ph
            ){
                //System.out.println("Canvas ADD:" + canvas.getAllObject().elementAt(i));
                canvas.selectedShapeVector.add(canvas.getAllObject().elementAt(i));
                //System.out.println("Canvas After:" + canvas.selectedShapeVector);

            }
        }
        canvas.setSelectedShapeVector();


    }

}
