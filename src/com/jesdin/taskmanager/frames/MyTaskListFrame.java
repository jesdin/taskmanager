package com.jesdin.taskmanager.frames;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;

public class MyTaskListFrame extends JFrame {
    public MyTaskListFrame() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        var btnNewTask = new JButton("New Task");
        add(btnNewTask);

        var pnlHighPriority = new JPanel();
        pnlHighPriority.add(new JLabel("High Priority"));
        var pnlHighPriorityContents = new JPanel();
        for (var t : MockTasks.getTasks()) {
            pnlHighPriorityContents.add(new JCheckBox(t.getTitle()));
        }
        pnlHighPriority.add(pnlHighPriorityContents);
        add(pnlHighPriority);

        setTitle("My Tasklist");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}