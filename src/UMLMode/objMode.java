package UMLMode;

import java.awt.event.MouseEvent;

public class objMode extends Mode{
    String objKind;
    public objMode(){
        //this.objKind = objKind;
    }

    //mouseClicked以後，做canvas中做mode的轉換，並且創
    public void mouseClicked(MouseEvent e) {
        System.out.println("eat pop");
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }
}
