package UMLMode;


import UMLObj.Shape;
import UMLObj.ClassObj;
import UMLObj.UseCaseObj;

import java.awt.*;

//Factory Design Pattern
public class BasicShapeFactory implements ShapeFactory{
    protected String objType;
    public BasicShapeFactory(String objType){
        this.objType = objType;
    }

    public Shape getShape(Point mouseLocation) {
        if (objType.equals("classObj")) {
            //System.out.println(mouseLocation);
            return new ClassObj(mouseLocation);
        }
        else if (objType.equals("useObj")) {
            return new UseCaseObj(mouseLocation);
        }
        return null;
    }

}
