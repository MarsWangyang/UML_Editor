package UMLObj;

import java.awt.*;

public abstract class LineObj extends Shape{

    @Override
    public void draggedMovement(Point point){}
    public void resetName(String newName) {}
    public Dimension getObjSize() {
        return null;
    }
    public void selectSwitch(Boolean chosen) {}
}
