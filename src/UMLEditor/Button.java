package UMLEditor;

import UMLMode.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    Mode toolMode;
    ImageIcon icon;
    String createObj;
    private Canvas canvas;
    private static JButton holdBtn = null;   //這裡不好，因為變成static的，大家都能夠去修改到他

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

    public void resetHoldBtn(JButton holdBtn) {
        this.holdBtn = holdBtn;
    }

    class InnerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(holdBtn);
            if (holdBtn != null) {
                holdBtn.setBackground(Color.CYAN);
            }
            holdBtn = (JButton) e.getSource(); // holdBtn拿到的是要JButton(也就是e.getSouce())
            System.out.println(holdBtn);
            holdBtn.setBackground(Color.RED);
            resetHoldBtn(holdBtn);
            canvas.currentShape = createObj;
            canvas.changeMode(toolMode);    //當action為點擊某個tool時，會在canvas中轉換成為那個Mode。
            canvas.listenerSetting();   //這裡去重新調整canvas中目前的listener應該是哪一種Mode的Listener
            canvas.repaint();
        }
    }

}


