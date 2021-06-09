package UMLMode;

import UMLObj.AssociateLine;
import UMLObj.CompositeLine;
import UMLObj.GeneralLine;
import UMLObj.Shape;

import java.awt.*;

public class LineShapeFactory implements ShapeFactory{
    protected String lineType = null;
    protected Point firstPort;
    protected Point secondPort;

    public LineShapeFactory(){

    }

    public LineShapeFactory(String lineType, Point firstPort, Point secondPort) {
        this.lineType = lineType;
        this.firstPort = firstPort;
        this.secondPort = secondPort;
    }

    @Override
    public Shape getShape(Point firstPort) {
        if (lineType.equals("associateLine")) {
            return new AssociateLine();
        }
        else if (lineType.equals("generalLine")) {
            return new GeneralLine();
        }
        else if (lineType.equals("compositeLine")){
            return new CompositeLine();
        }
        return null;
    }
}
