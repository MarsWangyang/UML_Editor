package UMLEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLMode.LineMode;
import UMLMode.ObjMode;
import UMLMode.SelectMode;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class ToolBar extends JToolBar {
    private Canvas canvas;
    private int toolNum = 6;
    private JButton holdBtn = null;

    public ToolBar() {
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1, 3, 3));


        //以下寫不太好 Button都是programming to implement
        Button selection = new Button("select.png", new SelectMode(), "selection");
        selection.addActionListener(new InnerListener());
        add(selection);

        Button associateLine = new Button("associate.png", new LineMode(), "associateLine");
        associateLine.addActionListener(new InnerListener());
        add(associateLine);

        Button generalLine = new Button("general.png", new LineMode(), "generalLine");
        generalLine.addActionListener(new InnerListener());
        add(generalLine);

        Button compositeLine = new Button("composite.png", new LineMode(), "compositeLine");
        compositeLine.addActionListener(new InnerListener());
        add(compositeLine);

        Button classObj = new Button("class.png", new ObjMode(), "classObj");
        classObj.addActionListener(new InnerListener());
        add(classObj);

        Button useObj = new Button("usecase.png", new ObjMode(), "useObj");
        useObj.addActionListener(new InnerListener());
        add(useObj);


    }


    public void resetHoldBtn(JButton holdBtn) {
        this.holdBtn = holdBtn;
    }

    //將button點擊變換顏色寫到這裡。
    class InnerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (holdBtn != null) {
                holdBtn.setBackground(Color.CYAN);
            }
            holdBtn = (JButton) e.getSource();
            holdBtn.setBackground(Color.RED);
            resetHoldBtn(holdBtn);
            canvas.repaint();
        }
    }
}


