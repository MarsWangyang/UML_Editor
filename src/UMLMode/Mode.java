package UMLMode;

import UMLEditor.Canvas;
import UMLObj.Shape;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public abstract class Mode extends MouseInputAdapter {
    Canvas canvas = Canvas.getInstance();


    public void mousePressed(MouseEvent e) {};

    public void mouseReleased(MouseEvent e) {};

    public void mouseClicked(MouseEvent e) {};

    public void mouseDragged(MouseEvent e) {};
}
