package UMLEditor;

import UMLMode.Mode;
import UMLMode.SelectMode;
import UMLObj.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.Vector;


//＊＊＊＊要改：mouseclick在裡面做動作
public class Canvas extends JPanel {
    private static Canvas uniqueInstance;
    private EventListener currentListener = null;
    private Vector<Shape> allObjectVector = new Vector();
    public String currentShape = null;  //Mode裡面會有很多Shape，這邊是看是什麼Shape
    private Mode currentMode; //看現在是哪種Mode
    public Shape selectedShape = null;
    public Vector<Shape> selectedShapeVector = new Vector();
    public int rectPointInitX = 0;
    public int rectPointInitY = 0;
    public int rectPointEndX = 0;
    public int rectPointEndY = 0;
    int alpha = 127;


    private Canvas(){}

    //做Singleton，避免其他重複建立相同物件
    //別人要來call Canvas，就要用Canvas.getInstance().methods
    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Canvas();
        }
        return uniqueInstance;
    }

    //toolBar點擊tool後會有Mode轉換
    public void changeMode(Mode reviseMode) {
        currentMode = reviseMode;
        //System.out.println(currentMode);
    }


    public void changeObj(String createObj) {
        currentShape = createObj;
    }


    //對整個canvas做MouseListener，因為canvas是JPanel，所以addXXXListener就會對整個Panel做admin
    //currentListener中會是inherit Adapter，因此裡面都是Mouse Action.
    public void listenerSetting() {
        removeMouseListener((MouseListener) currentListener);
        removeMouseMotionListener((MouseMotionListener) currentListener);
        currentListener = currentMode;
        addMouseListener((MouseListener) currentListener);
        addMouseMotionListener((MouseMotionListener) currentListener);
    }

    public void addShape(Shape shape) {
        allObjectVector.add(shape);
    }


    //有問題 還需要改
    public void setSelectedShape(Shape selectedShape) {
        if(this.selectedShape != null) {
            this.selectedShape.selectSwitch(false);
        }
        this.selectedShape = selectedShape;
        if (this.selectedShape != null) {
            this.selectedShape.selectSwitch(true);
        }
        repaint();
    }

    /*
    public void setSelectedShapeVector(Vector<Shape> currentShapeVector) {
        if(this.selectedShapeVector != null) {
            for (int i = 0; i < selectedShapeVector.size(); i ++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(false);
            }
        }
        this.selectedShapeVector = currentShapeVector;
        if (this.selectedShapeVector != null) {
            for (int i = 0; i < selectedShapeVector.size(); i ++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(true);
            }        }
        repaint();
    }

     */
    public void setSelectedShapeVectorFalse() {
        System.out.println(selectedShapeVector);
        if(selectedShapeVector.size() != 0) {
            for (int i = 0; i < selectedShapeVector.size(); i++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(false);
            }
        }
        repaint();
    }

    public void setSelectedShapeVector() {
        if (selectedShapeVector.size() != 0) {
            for (int i = 0; i < selectedShapeVector.size(); i++) {
                this.selectedShapeVector.elementAt(i).selectSwitch(true);
            }
        }

        repaint();
    }




    public void showShape(){
        for (int i = 0; i < allObjectVector.size(); i++) {
            System.out.println(allObjectVector.get(i));
            System.out.println(allObjectVector.elementAt(i).getInitPoint());
        }
    }

    public Vector<Shape> getAllObject(){
        return allObjectVector;
    }

    //Dragging後把selectedShape拉到allObjectVector最後一個，當作最上層
    public void setTopObject(Shape selectedShape) {
        for (int i = 0; i < allObjectVector.size(); i ++) {
            if (selectedShape.equals(allObjectVector.elementAt(i))) {
                allObjectVector.remove(i);
                allObjectVector.add(selectedShape);
            }
        }
        return ;
    }



    public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.fillRect(px, py, pw, ph);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < allObjectVector.size() ; i++) {
            Shape obj = allObjectVector.elementAt(i);
            obj.draw(g2);
        }

        g2.setPaint(new Color(155, 200, 123, alpha));
        drawPerfectRect(g2, rectPointInitX, rectPointInitY, rectPointEndX, rectPointEndY);

    }






}
