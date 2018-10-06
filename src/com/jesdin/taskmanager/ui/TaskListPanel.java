package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.events.ISubscriber;
import com.jesdin.taskmanager.events.EventChannel;
import com.jesdin.taskmanager.persistence.TasksRepository;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TaskListPanel extends JPanel  implements ISubscriber {

    private TaskListPanelType taskListPanelType;
    Frame owner;

    //constructors
    public TaskListPanel(TaskListPanelType taskListPanelType, Frame owner) {
        this.taskListPanelType = taskListPanelType;
        this.owner = owner;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String title;
        if(taskListPanelType.equals(TaskListPanelType.TASKS)) {
            title = "My Tasks";
        }
        else {
            title = "Completed Tasks";
        }
        setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(5, 0, 0, 0),
                new CompoundBorder(
                        BorderFactory.createTitledBorder(title),
                        BorderFactory.createEmptyBorder(5, 10, 0, 10)
                )
        ));
        addItems();

        EventChannel.subscribe(this);
    }

    private void addItems() {
        for (var task : new TasksRepository().get()) {
            if(taskListPanelType == TaskListPanelType.TASKS) {
                if(task.isCompleted()) {
                    continue;
                }
            }
            else if(taskListPanelType == TaskListPanelType.COMPLETED) {
                if (!task.isCompleted()) {
                    continue;
                }
            }

            var pnlLine = new JPanel();
            pnlLine.setLayout((new BoxLayout(pnlLine, BoxLayout.X_AXIS)));
            pnlLine.setAlignmentX(Component.LEFT_ALIGNMENT);

            if(task.isHighPriority()) {
                JLabel exclamation = new JLabel("!");
                exclamation.setForeground(Color.red);
                pnlLine.add(exclamation);
            }
            else{
                pnlLine.add(new JLabel(" "));
            }
            JCheckBox chkBox = new JCheckBox(task.getTitle());
            chkBox.setSelected(task.isCompleted());
            chkBox.addActionListener(e -> {
                if(chkBox.isSelected()) {
                    new TasksRepository().setCompleted(task.getId());
                }
                else {
                    new TasksRepository().setNotCompleted(task.getId());
                }
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
                            task
                    ).showDialog();
                }
            });
            pnlLine.add(hyperLink);

            //delete button
            try {
                JButton btnDelete = new JButton();
                Image img = ImageIO.read(getClass().getResource("resources/delete.png"));
                img = img.getScaledInstance(20, 20, 0);
                btnDelete.setMinimumSize(new Dimension(20, 20));
                btnDelete.setMaximumSize(new Dimension(20, 20));
                btnDelete.setPreferredSize(new Dimension(20, 20));
                btnDelete.setIcon(new ImageIcon(img));
                btnDelete.setBackground(new Color(0, 0, 0, 0));
                btnDelete.setOpaque(false);
                btnDelete.setBorderPainted(false);
                btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                pnlLine.add(Box.createHorizontalGlue());
                pnlLine.add(btnDelete);
                btnDelete.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        var result = JOptionPane.showConfirmDialog(owner,
                                "Are you sure?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION);
                        if(result == JOptionPane.YES_OPTION) {
                            new TasksRepository().delete(task.getId());
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            add(pnlLine);
        }
        add(Box.createHorizontalGlue()); //place holder
        add(Box.createVerticalGlue()); //adds space in between
    }

    @Override
    public void updateData() {
        removeAll();
        addItems();
        repaint();
        revalidate();
    }

// need to change addItems in this file and the para passing in TaskDialog
    enum TaskListPanelType {
        TASKS, COMPLETED
    }
}
