package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.IUpdateData;
import com.jesdin.taskmanager.MockTasks;
import com.jesdin.taskmanager.persistence.TasksRepository;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskListPanel extends JPanel  implements IUpdateData {

    private TaskListPanelType taskListPanelType;
    Frame owner;

    //constructors
    public TaskListPanel(TaskListPanelType taskListPanelType, Frame owner) {

        this.taskListPanelType = taskListPanelType;
        this.owner = owner;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(5, 0, 0, 0),
                new CompoundBorder(
                        BorderFactory.createTitledBorder(taskListPanelType.toString()),
                        BorderFactory.createEmptyBorder(5, 10, 0, 10)
                )
        ));

        addItems();

        MockTasks.events.add(this);
    }

    private void addItems() {
        for (var t : new TasksRepository().get()) {

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
                if(chkBox.isSelected()) {
                    new TasksRepository().setCompleted(t.getId());
                }
                else {
                    new TasksRepository().setNotCompleted(t.getId());
                }
                MockTasks.updateTask(t, chkBox.isSelected());
            });
            pnlLine.add(chkBox);

            JLabel hyperLink = new JLabel("Edit");
            hyperLink.setForeground(Color.decode("#6492B4"));
            hyperLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            hyperLink.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    new TaskDialog(owner,
                            "Edit Task",
                            TaskDialog.DIALOG_TYPE.editTask,
                            t
                    ).showDialog();
                }
            });
            pnlLine.add(hyperLink);

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
        repaint();
        revalidate();
    }

// need to change addItems in this file and the para passing in TaskDialog
    enum TaskListPanelType {
        HIGH_PRIORITY, OTHER, COMPLETED
    }
}
