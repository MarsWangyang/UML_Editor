package UMLEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLMode.Mode;
import UMLMode.lineMode;
import UMLMode.objMode;
import UMLMode.selectMode;

public class ToolBar extends JToolBar {
    private Canvas canvas;
    private int toolNum = 6;


    public ToolBar() {
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1, 3, 3));

        Button selection = new Button("select.png", new selectMode(), "selection");
        add(selection);

        Button associateLine = new Button("associate.png", new lineMode(), "associateLine");
        add(associateLine);

        Button generalLine = new Button("general.png", new lineMode(), "generalLine");
        add(generalLine);

        Button compositeLine = new Button("composite.png", new lineMode(), "compositeLine");
        add(compositeLine);

        Button classObj = new Button("class.png", new objMode(), "classObj");
        add(classObj);

        Button useObj = new Button("usecase.png", new objMode(), "useObj");
        add(useObj);
        System.out.println("111111");

    }


        //abstract Mode class extend Mouseinput adapter

}


