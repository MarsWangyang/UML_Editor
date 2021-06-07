package UMLMode;


import UMLObj.BasicObj;
import UMLObj.Shape;


import java.awt.event.MouseEvent;


//在這個class中，會做到的事是依照點選哪個tool，create一個obj
public class objMode extends Mode {
    basicShapeFactory shapeFactory = new basicShapeFactory();

    public void mousePressed(MouseEvent e) {
        //想做到的事 這邊就會create BasicObj
        Shape basicObj = shapeFactory.getShape(canvas.currentShape);
        System.out.println(canvas.currentShape);
        System.out.println("pressed");
    }

    public void test(){

    }


}
