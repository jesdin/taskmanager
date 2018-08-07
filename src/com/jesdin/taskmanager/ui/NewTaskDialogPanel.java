package com.jesdin.taskmanager.ui;

import javax.swing.*;
import java.awt.*;

public class NewTaskDialogPanel extends JDialog {
    //constructor
    public NewTaskDialogPanel(Frame owner, String title) {
        super(owner, title, true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtInput = new JTextField();
        txtInput.setColumns(25);

        ButtonGroup bgPriority = new ButtonGroup();
        JRadioButton rbHighPriority = new JRadioButton("High Priority");
        JRadioButton rbOther = new JRadioButton("Other");
        bgPriority.add(rbHighPriority);
        bgPriority.add(rbOther);

        JPanel pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout());
        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");
        pnlBtn.add(save);
        pnlBtn.add(cancel);

        add(new JLabel("Enter New Task"));
        add(txtInput);
        add(rbHighPriority);
        add(rbOther);
        add(pnlBtn);
        pack();
    }

    public void showDialog() {

        setVisible(true);
    }
}
