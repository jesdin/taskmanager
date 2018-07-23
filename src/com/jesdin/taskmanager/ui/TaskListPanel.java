package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;

public class TaskListPanel extends JPanel {

    //constructors
    public TaskListPanel(String title) {
        add(new JLabel(title));
        var pnlContent = new JPanel();
        for (var t : MockTasks.getTasks()) {
            //no object required as it is a static method
            pnlContent.add(new JCheckBox(t.getTitle()));
            pnlContent.add(new JButton("Edit"));
        }
        add(pnlContent);
    }
}