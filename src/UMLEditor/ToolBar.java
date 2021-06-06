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
    private JButton holdBtn = null;

    public ToolBar() {
        canvas = Canvas.getInstance();
        setLayout(new GridLayout(toolNum, 1, 2, 2));

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
    }


    private class Button extends JButton{
        Mode toolMode;
        ImageIcon icon;
        String createObj;

        public Button(String filename, Mode toolMode, String createObj){
            this.toolMode = toolMode;
            this.createObj = createObj;
            //System.out.println(toolMode);
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
                holdBtn = (JButton) e.getSource(); // holdBtn拿到的是要JButton(也就是e.getSouce())
                holdBtn.setBackground(Color.RED);
                canvas.changeMode(toolMode);    //當action為點擊某個tool時，會在canvas中轉換成為那個Mode。
                canvas.listenerSetting();   //這裡去重新調整canvas中目前的listener應該是哪一種Mode的Listener
                canvas.repaint();
            }
        }

    }
    //abstract Mode class extend Mouseinput adapter

}


