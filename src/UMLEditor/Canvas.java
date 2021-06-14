package UMLEditor;

import UMLMode.Mode;
import UMLObj.BasicObj;
import UMLObj.LineObj;
import UMLObj.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.Vector;

public class Canvas extends JPanel {
    private static Canvas uniqueInstance;
    private EventListener currentListener = null;
    private Vector<Shape> allObjectVector = new Vector();
    public String currentShape = null;  //Mode裡面會有很多Shape，這邊是看是什麼Shape
    private Mode currentMode; //看現在是哪種Mode
    public Shape selectedShape = null;
    public int rectPointInitX = 0;
    public int rectPointInitY = 0;
    public int rectPointEndX = 0;
    public int rectPointEndY = 0;
    private Vector<LineObj> lineVector = new Vector();

    private Canvas(){}

    //做Singleton，避免其他重複建立相同物件
    //別人要來call Canvas，就要用Canvas.getInstance().methods
    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Canvas();
        }
        return uniqueInstance;
    }



    public void addShape(Shape shape) {
        allObjectVector.add(shape);
    }

    public void addVectorShape(LineObj line) {
        lineVector.add(line);
    }

    public Vector<Shape> getAllObject() {
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


    //Single shape被click的時候的port的顯示
    public void setSelectedShape(Shape selectedShape) {
        if(this.selectedShape != null) {
            ((BasicObj)this.selectedShape).selectSwitch(false);
        }
        this.selectedShape = selectedShape;
        if (this.selectedShape != null) {
            ((BasicObj)this.selectedShape).selectSwitch(true);
        }
        repaint();
    }


    //toolBar點擊tool後會有Mode轉換
    public void changeMode(Mode reviseMode) {
        currentMode = reviseMode;
        //System.out.println(currentMode);
    }

    //替換toolbar上面的object為誰(not mode)
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = allObjectVector.size()-1; i >= 0; i--) {
            Shape obj = allObjectVector.elementAt(i);
            obj.draw(g2);
        }

        for (int i = 0; i < lineVector.size(); i++) {
            Shape line = lineVector.elementAt(i);
            line.draw(g2);
        }





    }
}
