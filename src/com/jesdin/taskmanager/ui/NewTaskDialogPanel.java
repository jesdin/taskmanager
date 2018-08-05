package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;

public class NewTaskDialogPanel extends JPanel {
    //constructor
    public NewTaskDialogPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTextField txtInput = new JTextField();
        txtInput.setColumns(25);
        MockTasks.newTask(txtInput.getText());

        ButtonGroup bgPriority = new ButtonGroup();
        JRadioButton rbHighPriority = new JRadioButton("High Priority");
        JRadioButton rbOther = new JRadioButton("Other");
        bgPriority.add(rbHighPriority);
        bgPriority.add(rbOther);

        add(new JLabel("Enter New Task"));
        add(txtInput);
        add(rbHighPriority);
        add(rbOther);
    }
}
