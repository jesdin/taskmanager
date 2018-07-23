package com.jesdin.taskmanager;

import com.jesdin.taskmanager.models.Task;

public class MockTasks {

    //private fields
    private static Task[] tasks = new Task[] {
        new Task("Buy Eggs"),
        new Task("Complete Data Structure assignment")
    };

    //methods
    public static Task[] getTasks() {
        return tasks;
    }
}
