package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;
import com.jesdin.taskmanager.TasksRepository;
import com.jesdin.taskmanager.models.Task;

import javax.swing.*;
import java.awt.*;

public class TaskDialog extends JDialog {
    //constructor
    public TaskDialog(Frame owner, String title, DIALOG_TYPE dialogType, Task task) {
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

        add(new JLabel("Task Title"));

        if(dialogType == DIALOG_TYPE.editTask) {
            txtInput.setText(task.getTitle());
            rbHighPriority.setSelected(task.isHighPriority());
            rbOther.setSelected(!task.isHighPriority());
        }
        add(txtInput);
        add(rbHighPriority);
        add(rbOther);
        add(pnlBtn);
        pack();

        btnSave.addActionListener(e -> {
            task.setTitle(txtInput.getText());
            task.setHighPriority(rbHighPriority.isSelected());

            if(dialogType == DIALOG_TYPE.editTask) {
                new TasksRepository().edit(task);
                MockTasks.updateTask(task, task.isCompleted());
            }
            else {
                new TasksRepository().add(task);
                MockTasks.newTask(txtInput.getText(), rbHighPriority.isSelected());
            }
            dispose();
        });
        btnCancel.addActionListener(e -> {
                dispose();
            }
        );
    }

    public TaskDialog(Frame owner, String title, DIALOG_TYPE dialogType) {
        this(owner, title, dialogType, new Task());
    }

    public void showDialog() {

        setVisible(true);
    }

    enum DIALOG_TYPE {
        newTask,
        editTask;
    };
}
