package UMLEditor;

import UMLMode.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//u要把holdbtn改到toolbar裡面去 -> button只負責call API新增button
public class Button extends JButton {
    Mode toolMode;
    ImageIcon icon;
    String createObj;
    private Canvas canvas;


    public Button (String filename, Mode toolMode, String createObj) {
        canvas = Canvas.getInstance();
        this.toolMode = toolMode;
        this.createObj = createObj;
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

    // Button is chosen by user and according different button to change different mode.
    class InnerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.changeObj(createObj);  //去改變canvas裡面的currentShape，也就是改變現在的object
            canvas.changeMode(toolMode);    //當action為點擊某個tool時，會在canvas中轉換成為那個Mode。
            canvas.listenerSetting();   //這裡去重新調整canvas中目前的listener應該是哪一種Mode的Listener
        }
    }
}


