package UMLMode;

import UMLObj.BasicObj;
import UMLObj.LineObj;
import UMLObj.Shape;

import java.awt.*;

public abstract class ShapeFactory {
    public abstract BasicObj objGetShape(Point point);

    public abstract LineObj lineGetShape();
}
