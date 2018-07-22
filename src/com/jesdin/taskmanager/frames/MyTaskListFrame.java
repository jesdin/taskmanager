package com.jesdin.taskmanager.frames;

import javax.swing.*;

public class MyTaskListFrame extends JFrame {
    public MyTaskListFrame() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        var btnNewTask = new JButton("New Task");
        add(btnNewTask);

        setTitle("My Tasklist");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}