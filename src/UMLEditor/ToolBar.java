package UMLEditor;

import javax.swing.*;
import java.awt.*;

import UMLMode.LineMode;
import UMLMode.ObjMode;
import UMLMode.SelectMode;

public class ToolBar extends JToolBar {
    private Canvas canvas;
    private int toolNum = 6;


    public ToolBar() {
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1, 3, 3));

        Button selection = new Button("select.png", new SelectMode(), "selection");
        add(selection);

        Button associateLine = new Button("associate.png", new LineMode(), "associateLine");
        add(associateLine);

        Button generalLine = new Button("general.png", new LineMode(), "generalLine");
        add(generalLine);

        Button compositeLine = new Button("composite.png", new LineMode(), "compositeLine");
        add(compositeLine);

        Button classObj = new Button("class.png", new ObjMode(), "classObj");
        add(classObj);

        Button useObj = new Button("usecase.png", new ObjMode(), "useObj");
        add(useObj);
    }


        //abstract Mode class extend Mouseinput adapter

}


