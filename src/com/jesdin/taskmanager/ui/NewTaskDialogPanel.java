package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;
import java.awt.*;

public class NewTaskDialogPanel extends JDialog {
    //constructor
    public NewTaskDialogPanel(Frame owner, String title, DIALOG_TYPE dialogType) {
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
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        pnlBtn.add(btnSave);
        pnlBtn.add(btnCancel);

        add(new JLabel("Enter New Task"));
        add(txtInput);
        add(rbHighPriority);
        add(rbOther);
        add(pnlBtn);
        pack();

        btnSave.addActionListener(e -> {
                    MockTasks.newTask(txtInput.getText(), rbHighPriority.isSelected());
                    dispose();
                }
        );
        btnCancel.addActionListener(e -> {
                dispose();
            }
        );
    }

    public void showDialog() {

        setVisible(true);
    }

    enum DIALOG_TYPE {
        newTask,
        editTask;
    };
}
