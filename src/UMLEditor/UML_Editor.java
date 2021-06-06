package UMLEditor;

import javax.swing.*;
import java.awt.*;

public class UML_Editor {
    public static void main(String[] args) {
        JFrame editor = new JFrame("UML Editor");
        Container container = editor.getContentPane();
        Canvas canvas = Canvas.getInstance();
        MenuBar menuBar = new MenuBar();
        ToolBar toolBar = new ToolBar();
        canvas.setBackground(Color.DARK_GRAY);
        container.add(canvas);


        container.add(toolBar, BorderLayout.WEST);
        editor.setJMenuBar(menuBar);
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setSize(1200, 750);

        editor.setVisible(true);
    }
}
