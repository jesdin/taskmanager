package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.IUpdateData;
import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class TaskListPanel extends JPanel  implements IUpdateData {

    private TaskListPanelType p;

    //constructors
    public TaskListPanel(TaskListPanelType p) {

        this.p = p;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(5, 0, 0, 0),
                new CompoundBorder(
                        BorderFactory.createTitledBorder(p.toString()),
                        BorderFactory.createEmptyBorder(5, 10, 0, 10)
                )
        ));

        addItems();

        MockTasks.events.add(this);
    }

    private void addItems() {
        for (var t : MockTasks.getTasks()) {
            if(p.equals(TaskListPanelType.HIGH_PRIORITY)) {
                if(t.isHighPriority()) {
                    var pnlLine = new JPanel();
                    pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
                    pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);
                    pnlLine.add(new JCheckBox(t.getTitle()));
                    pnlLine.add(new JButton("Edit"));
                    add(pnlLine);
                }
            }
            if(p.equals(TaskListPanelType.OTHER)) {
                if(!t.isHighPriority()) {
                    var pnlLine = new JPanel();
                    pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
                    pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);
                    pnlLine.add(new JCheckBox(t.getTitle()));
                    pnlLine.add(new JButton("Edit"));
                    add(pnlLine);
                }
            }
            if(p.equals(TaskListPanelType.COMPLETED)) {
                if(t.isCompleted()) {
                    var pnlLine = new JPanel();
                    pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
                    pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);
                    pnlLine.add(new JCheckBox(t.getTitle()));
                    pnlLine.add(new JButton("Edit"));
                    add(pnlLine);
                }
            }
        }
        add(Box.createHorizontalGlue()); //place holder
        add(Box.createVerticalGlue()); //adds space in between
    }

    @Override
    public void updateData() {
        System.out.println("Updating data");
        removeAll();
        addItems();
        revalidate();
    }

// need to change addItems in this file and the para passing in NewTaskDialogPanel
    enum TaskListPanelType {
        HIGH_PRIORITY, OTHER, COMPLETED
    }
}
