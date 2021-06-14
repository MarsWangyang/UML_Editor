package UMLMode;

import UMLObj.Shape;

import java.awt.event.MouseEvent;

public class ObjMode extends Mode{
    ShapeFactory shapeFactory ;

    public void mouseReleased(MouseEvent e) {
        System.out.println("---Object Mode Release---");
        //ShapeFactory Design Pattern
        shapeFactory = new BasicShapeFactory(canvas.currentShape); //根據每次mouse查看當下的ShapeType
        Shape basicObj = shapeFactory.objGetShape(e.getPoint());//這邊會create BasicObj(Shape basicObj)
        canvas.addShape(basicObj); //把basicObj加入allObjectVector當中
        //canvas.showShape(); //看一下目前有什麼BasicShape在Canvas當中
        //System.out.println(canvas.currentShape);
        //System.out.println("----------------");
        canvas.repaint();
    }
}
