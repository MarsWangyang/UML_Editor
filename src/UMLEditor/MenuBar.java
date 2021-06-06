package UMLEditor;

import javax.swing.*;

public class MenuBar extends JMenuBar{
    Canvas canvas;
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenuItem ungroup = new JMenuItem("Ungroup");
    JMenuItem group = new JMenuItem("Group");
    JMenuItem rename = new JMenuItem("Rename");

    public MenuBar() {
        canvas = Canvas.getInstance();
        editMenu.add(rename);
        editMenu.add(group);
        editMenu.add(ungroup);
        add(fileMenu);
        add(editMenu);
    }



}
