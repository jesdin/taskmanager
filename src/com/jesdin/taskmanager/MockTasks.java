package com.jesdin.taskmanager;

import com.jesdin.taskmanager.models.Task;

import java.util.ArrayList;

public class MockTasks {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static ArrayList<ISubscriber> subscribers = new ArrayList<>();

    //constructor
    static {
        tasks.add(new Task("Buy Eggs", true));
        tasks.add(new Task("Complete Data Structure Project", true));
        tasks.add(new Task("Play Free Fire", false));
    }

    //methods
    public static void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static Task[] getTasks() {
        return tasks.toArray(new Task[tasks.size()]);
    }

    public static void newTask(String t, boolean priority) {
        tasks.add(new Task(t, priority));
        triggerEvent();
    }

    public static void updateTask(Task t, boolean completed) {
        t.setCompleted(completed);
        triggerEvent();
    }

    private static void triggerEvent() {
        for (var e: subscribers) {
            e.updateData();
        }
    }
}
