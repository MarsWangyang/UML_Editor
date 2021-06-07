package UMLMode;

import UMLObj.Shape;

public interface ShapeFactory {
    Shape getShape(String objType);
}
