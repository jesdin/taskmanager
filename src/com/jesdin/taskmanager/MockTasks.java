package com.jesdin.taskmanager;

import com.jesdin.taskmanager.models.Task;

import java.util.ArrayList;

public class MockTasks {

    private static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<IUpdateData> events = new ArrayList<>();

    //constructor
    static {
        tasks.add(new Task("Buy Eggs"));
        tasks.add(new Task("Complete Data Structure Project"));
        tasks.add(new Task("Play Free Fire"));
    }

    //methods
    public static Task[] getTasks() {
        return tasks.toArray(new Task[tasks.size()]);
    }
    public static void newTask(String t) {
        tasks.add(new Task(t));
        for (var e: events) {
            e.updateData();
        }
    }
}
