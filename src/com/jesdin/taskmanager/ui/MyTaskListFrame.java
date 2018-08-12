package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;

public class MyTaskListFrame extends JFrame{
    public MyTaskListFrame() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //padding
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        var btnNewTask = new JButton("New Task");

        //lambda listener
        btnNewTask.addActionListener(e -> {
                new NewTaskDialogPanel(this, "New Task").showDialog();
                System.out.println("In event listner");
            }
        );
        add(btnNewTask);

        add(new TaskListPanel(TaskListPanel.TaskListPanelType.HIGH_PRIORITY));
        add(new TaskListPanel(TaskListPanel.TaskListPanelType.OTHER));
        add(new TaskListPanel(TaskListPanel.TaskListPanelType.COMPLETED));

        setTitle("My Tasklist");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
