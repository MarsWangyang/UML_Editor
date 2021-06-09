package UMLEditor;

import UMLMode.Mode;
import UMLObj.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;
import java.util.Vector;

public class Canvas extends JPanel {
    private static Canvas uniqueInstance;
    private Mode currentMode;
    private EventListener currentListener = null;
    private Vector<Shape> allObjectVector = new Vector<Shape>();
    public String currentShape = null;


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
        System.out.println(currentMode);
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

    public void showShape(){
        System.out.println(allObjectVector);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0; i < allObjectVector.size(); i++) {
            Shape obj = allObjectVector.elementAt(i);
            obj.draw(g2);

        }
    }






}
