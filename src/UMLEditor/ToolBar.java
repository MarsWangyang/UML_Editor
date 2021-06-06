package UMLEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UMLMode.Mode;
import UMLMode.lineMode;
import UMLMode.objMode;
import UMLMode.selecMode;

public class ToolBar extends JToolBar {
    private Canvas canvas;
    private int toolNum = 6;
    private JButton holdBtn = null;

    public ToolBar() {
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1, 2, 2));

        Button selection = new Button("select.png", new selecMode());
        add(selection);

        Button associateLine = new Button("associate.png", new lineMode());
        add(associateLine);

        Button generalLine = new Button("general.png", new lineMode());
        add(generalLine);

        Button compositeLine = new Button("composite.png", new lineMode());
        add(compositeLine);

        Button classObj = new Button("class.png", new objMode());
        add(classObj);

        Button useObj = new Button("usecase.png", new objMode());
        add(useObj);
    }




    private class Button extends JButton{
        Mode toolMode;
        ImageIcon icon;

        public Button(String filename, Mode toolMode){
            this.toolMode = toolMode;
            initBtn(filename);
            this.addActionListener(new InnerListener());
        }

        //設定初始化的Button
        public void initBtn(String filename){
            icon = new ImageIcon(filename);
            setIcon(icon);
            setFocusable(false);
            this.setBackground(Color.CYAN);
            this.setOpaque(true);
            setBorderPainted(false);
            setRolloverEnabled(true);
        }


        class InnerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (holdBtn != null) {
                    holdBtn.setBackground(Color.CYAN);
                }
                holdBtn = (JButton) e.getSource();
                holdBtn.setBackground(Color.RED);
                canvas.repaint();
            }
        }

    }
    //abstract Mode class extend Mouseinput adapter

}


