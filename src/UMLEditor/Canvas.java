package UMLEditor;

import javax.swing.*;

public class Canvas extends JPanel{
    private static Canvas uniqueInstance;

    //private JFrame frame = new JFrame();

    private Canvas(){}

    //做Singleton，避免其他重複建立相同物件
    //別人要來call Canvas，就要用Canvas.getInstance().methods
    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Canvas();
        }
        return uniqueInstance;
    }




}
