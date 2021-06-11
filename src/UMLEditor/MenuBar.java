package UMLEditor;

import UMLObj.BasicObj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;


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
        rename.addActionListener(new RenameListener());
        group.addActionListener(new GroupListener());
        ungroup.addActionListener(new UngroupListener());
    }

    class RenameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JDialog renameDialog = new JDialog();
            JTextField newName = new JTextField("Default");
            JButton confirm = new JButton("Confirm");
            JButton cancel = new JButton("Cancel");
            Point dim = renameDialog.getLocation();
            int nameLocX = (int) dim.getX() + 25;
            int nameLocY = (int) dim.getY() + 10;
            int buttonLocY = nameLocY + 50;



            newName.setBounds(nameLocX, nameLocY, 250, 35);

            confirm.setBounds(nameLocX+10, buttonLocY, 100, 45);
            confirm.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            //把newName叫進來去更換

                            renameDialog.dispose();
                        }
                    }
            );

            cancel.setBounds(nameLocX+140, buttonLocY, 100, 45);
            cancel.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            renameDialog.dispose();
                        }
                    }
            );

            renameDialog.setLayout(null);
            renameDialog.add(newName);
            renameDialog.add(confirm);
            renameDialog.add(cancel);
            renameDialog.setSize(300,200);
            renameDialog.setLocationRelativeTo(null);


            renameDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

            renameDialog.setVisible(true);
        }
    }

    class GroupListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    class UngroupListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

        }
    }



}
