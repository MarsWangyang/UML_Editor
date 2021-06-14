package UMLMode;

import UMLObj.*;

import java.awt.*;

public class LineShapeFactory extends ShapeFactory{
    protected String lineType = null;
    Point firstPort;
    Point secondPort;

    public LineShapeFactory(String lineType, Point firstPort, Point secondPort) {
        this.lineType = lineType;
        this.firstPort = firstPort;
        //System.out.println("this.firstPort: " + this.firstPort);
        this.secondPort = secondPort;
    }


    @Override
    public LineObj lineGetShape() {
        if (lineType.equals("associateLine")) {
            return new AssociateLine(this.firstPort, this.secondPort);
        }
        else if (lineType.equals("generalLine")) {
            return new GeneralLine(this.firstPort, this.secondPort);
        }
        else if (lineType.equals("compositeLine")){
            return new CompositeLine(this.firstPort, this.secondPort);
        }
        return null;
    }


    @Override
    public BasicObj objGetShape(Point point) {
        return null;
    }
}
