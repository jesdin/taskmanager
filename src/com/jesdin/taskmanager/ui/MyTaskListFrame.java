package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;

public class MyTaskListFrame extends JFrame {
    public MyTaskListFrame() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        var btnNewTask = new JButton("New Task");
        add(btnNewTask);

        add(new TaskListPanel("High Priority"));

        setTitle("My Tasklist");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}