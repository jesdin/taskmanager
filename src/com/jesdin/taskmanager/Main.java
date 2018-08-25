package com.jesdin.taskmanager;

import com.jesdin.taskmanager.models.Task;
import com.jesdin.taskmanager.ui.MyTaskListFrame;

public class Main {

    public static void main(String[] args) {
        // new MyTaskListFrame();

        TasksRepository tasksRepository = new TasksRepository();
        var tasks = tasksRepository.get();
        for (var t : tasks) {
            System.out.println(t.getTitle());
        }
    }
}