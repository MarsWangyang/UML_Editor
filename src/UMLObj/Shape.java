package UMLObj;

import java.awt.*;

public abstract class Shape {



    public void resetLocation (Point mouseDragLoc) {   //Object Relocate

    }

    public void resetLocation () {      //Line Relocate

    }

    public abstract Point getInitPoint();



    public abstract void draw(Graphics g);

    //public abstract void draw();
}
