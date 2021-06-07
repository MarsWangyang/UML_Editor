package UMLMode;


import UMLObj.BasicObj;
import UMLObj.Shape;
import UMLObj.classObj;
import UMLObj.useCaseObj;

//Factory Design Pattern
public class basicShapeFactory implements ShapeFactory{

    public Shape getShape(String objType) {
        if (objType.equals("classObj")) {
            return new classObj();
        }
        else if (objType.equals("useObj")) {
            return new useCaseObj();
        }
        return null;
    }

}
