package UMLMode;

import UMLObj.Shape;

import java.awt.*;

public interface ShapeFactory {
    Shape getShape(Point point);

}
