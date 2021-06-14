package UMLMode;

import UMLObj.BasicObj;
import UMLObj.LineObj;
import UMLObj.Port;
import UMLObj.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LineMode extends Mode{
    ShapeFactory shapeFactory;
    Point initPoint;
    Point endPoint;
    Port endPort;
    Port initPort;

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("---Line Mode Press---");
        if (PortDetection(e.getPoint()) != null) {
            System.out.println("Initial Point:" + PortDetection(e.getPoint()));
            this.initPort = PortDetection(e.getPoint());
            this.initPoint = PortDetection(e.getPoint()).getPort(); //取對準Port上面的Point
        }
        else{
            this.initPoint = null;
        }
        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("---Line Mode Drag---");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("---Line Mode Release---");
        if (PortDetection(e.getPoint()) != null) {
            System.out.println("End Point:" + PortDetection(e.getPoint()));
            this.endPort = PortDetection(e.getPoint());
            this.endPoint = PortDetection(e.getPoint()).getPort();
            shapeFactory = new LineShapeFactory(canvas.currentShape, this.initPoint, this.endPoint);
            LineObj line = shapeFactory.lineGetShape();
            this.initPort.addLine(line);    //initport加入line
            this.endPort.addLine(line);     //endport加入Line
            line.setLinePort(initPort, endPort);
            canvas.addVectorShape(line);
        }
        else{
            //清空initial Point、Port
            this.initPoint = null;
            this.endPoint = null;
            this.endPort = null;
            this.initPort = null;
        }
        canvas.repaint();
    }



    public Port PortDetection(Point mouseLoc) {
        //Boolean portDetect = false;
        int mouseLocX = (int) mouseLoc.getX();
        int mouseLocY = (int) mouseLoc.getY();
        //System.out.println("mouseLocX: " + mouseLocX);
        //System.out.println("mouseLocY: " + mouseLocY);


        for (int i = 0; i < canvas.getAllObject().size(); i++) {
            BasicObj obj = (BasicObj) canvas.getAllObject().elementAt(i);
            Port[] portArr = obj.getPortLocation();
            if (portArr.length != 0) {
                for (int ele = 0; ele < portArr.length; ele++) {
                    int objPortX = (int) portArr[ele].getPort().getX();
                    int objPortY = (int) portArr[ele].getPort().getY();
                    int detectWidth = 50;
                    int detectedHeight = 50;

                    if ((objPortX - detectWidth / 2) <= mouseLocX &&
                            mouseLocX <= (objPortX + detectWidth / 2) &&
                            (objPortY - detectedHeight / 2) <= mouseLocY &&
                            mouseLocY <= (objPortY + detectedHeight / 2)
                    ) {
                        //portDetect = true;
                        System.out.println("YES!!! It's port!");
                        return portArr[ele];
                    }
                }
            }
        }

        System.out.println("PortDetection End");
        return null;
    }



}
