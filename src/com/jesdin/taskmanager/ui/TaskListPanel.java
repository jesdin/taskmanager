package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.IUpdateData;
import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class TaskListPanel extends JPanel  implements IUpdateData {

    private TaskListPanelType taskListPanelType;

    //constructors
    public TaskListPanel(TaskListPanelType p) {

        this.taskListPanelType = p;

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

            if(taskListPanelType == TaskListPanelType.HIGH_PRIORITY) {
                if(t.isHighPriority() && !t.isCompleted()) {
                }
                else{
                    continue;
                }
            }
            else if(taskListPanelType == TaskListPanelType.OTHER) {
                if (!t.isHighPriority() && !t.isCompleted()) {
                }
                else{
                    continue;
                }
            }
            else if(taskListPanelType == TaskListPanelType.COMPLETED) {
                if (t.isCompleted()) {
                } else {
                    continue;
                }
            }

            var pnlLine = new JPanel();
            pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
            pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);
            JCheckBox chkBox = new JCheckBox(t.getTitle());
            chkBox.setSelected(t.isCompleted());
            chkBox.addActionListener(e -> {
                MockTasks.updateTask(t, chkBox.isSelected());
            });
            pnlLine.add(chkBox);
            pnlLine.add(new JButton("Edit"));

            add(pnlLine);
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
