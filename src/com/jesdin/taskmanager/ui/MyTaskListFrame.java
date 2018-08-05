package com.jesdin.taskmanager.ui;

import com.jesdin.taskmanager.MockTasks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTaskListFrame extends JFrame {
    public MyTaskListFrame() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        //padding
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

        var btnNewTask = new JButton("New Task");

        //lambda listener
        btnNewTask.addActionListener(e -> {

                JPanel pnlNewTask = new JPanel();
                pnlNewTask.setLayout(new BoxLayout(pnlNewTask, BoxLayout.Y_AXIS));

                JTextField txtInput = new JTextField();
                txtInput.setColumns(25);
                MockTasks.newTask(txtInput.getText());

                ButtonGroup bgPriority = new ButtonGroup();
                JRadioButton rbHighPriority = new JRadioButton("High Priority");
                JRadioButton rbOther = new JRadioButton("Other");
                bgPriority.add(rbHighPriority);
                bgPriority.add(rbOther);

                pnlNewTask.add(new JLabel("Enter New Task"));
                pnlNewTask.add(txtInput);
                pnlNewTask.add(rbHighPriority);
                pnlNewTask.add(rbOther);

                JOptionPane.showMessageDialog(getContentPane(), pnlNewTask, "New Task", JOptionPane.PLAIN_MESSAGE);
            }
        );
        add(btnNewTask);

        add(new TaskListPanel("High Priority"));
        add(new TaskListPanel("Other Tasks"));
        add(new TaskListPanel("Completed"));

        setTitle("My Tasklist");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}