package UMLMode;

import UMLObj.AssociateLine;
import UMLObj.CompositeLine;
import UMLObj.GeneralLine;
import UMLObj.Shape;

public class lineShapeFactory implements ShapeFactory{

    @Override
    public Shape getShape(String objType) {
        if (objType.equals("associateLine")) {
            return new AssociateLine();
        }
        else if (objType.equals("generalLine")) {
            return new GeneralLine();
        }
        else if (objType.equals("compositeLine")){
            return new CompositeLine();
        }
        return null;
    }
}
