package UMLMode;

import UMLObj.*;


import java.awt.*;

public class BasicShapeFactory extends ShapeFactory {
    protected String objType;
    public BasicShapeFactory(String objType){
        this.objType = objType;
    }

    @Override
    public BasicObj objGetShape(Point mouseLocation) {
        if (objType.equals("classObj")) {
            //System.out.println(mouseLocation);
            return new ClassObj(mouseLocation);
        }
        else if (objType.equals("useObj")) {
            return new UseCaseObj(mouseLocation);
        }
        return null;
    }

    @Override
    public LineObj lineGetShape() {
        return null;
    }
}
