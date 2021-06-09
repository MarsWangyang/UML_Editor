package UMLMode;


import UMLObj.Shape;
import java.awt.event.MouseEvent;


//在這個class中，會做到的事是依照點選哪個tool，create一個obj
public class ObjMode extends Mode {
    ShapeFactory shapeFactory ;

    public void mouseReleased(MouseEvent e) {

        shapeFactory = new BasicShapeFactory(canvas.currentShape); //根據每次mouse查看當下的ShapeType
        Shape basicObj = shapeFactory.getShape(e.getPoint());//這邊會create BasicObj(Shape basicObj)
        canvas.addShape(basicObj); //把basicObj加入allObjectVector當中
        //canvas.showShape(); //看一下目前有什麼BasicShape在Canvas當中
        System.out.println(canvas.currentShape);
        System.out.println("----------------");
        canvas.repaint();
    }



}
