package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.persistence.TasksRepository;
import com.jesdin.taskmanager.models.Task;

import javax.swing.*;
import java.awt.*;

public class TaskDialog extends JDialog {
    private final TasksRepository repo = new TasksRepository();

    //constructor
    public TaskDialog(Frame owner, String title, DIALOG_TYPE dialogType, Task task) {
        super(owner, title, true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextField txtInput = new JTextField();
        txtInput.setColumns(25);

        JCheckBox isHighPriority = new JCheckBox("High Priority");

        JPanel pnlBtn = new JPanel();
        pnlBtn.setLayout(new FlowLayout());
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        pnlBtn.add(btnSave);
        pnlBtn.add(btnCancel);

        add(new JLabel("Task Title"));

        if(dialogType == DIALOG_TYPE.editTask) {
            txtInput.setText(task.getTitle());
            isHighPriority.setSelected(task.isHighPriority());
        }
        add(txtInput);
        add(isHighPriority);
        add(pnlBtn);
        pack();

        btnSave.addActionListener(e -> {
            task.setTitle(txtInput.getText());
            task.setHighPriority(isHighPriority.isSelected());

            if(dialogType == DIALOG_TYPE.editTask) {
                repo.edit(task);
            }
            else {
                repo.add(task);
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
