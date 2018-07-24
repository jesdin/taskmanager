package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;
import java.awt.*;

public class TaskListPanel extends JPanel {

    //constructors
    public TaskListPanel(String title) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel(title));
        for (var t : MockTasks.getTasks()) {
            //no object required as it is a static method
            var pnlLine = new JPanel();
            pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
            pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlLine.add(new JCheckBox(t.getTitle()));
            pnlLine.add(new JButton("Edit"));
            add(pnlLine);
        }
        add(Box.createVerticalGlue()); //adds space in between
    }
}