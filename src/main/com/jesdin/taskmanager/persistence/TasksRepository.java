package com.jesdin.taskmanager.persistence;

import com.jesdin.taskmanager.events.EventChannel;
import com.jesdin.taskmanager.models.Task;
import com.jesdin.taskmanager.mytaskapi.MyAPI;
import com.jesdin.taskmanager.mytaskapi.implementation.MyAPIImpl;
import com.jesdin.taskmanager.mytaskapi.models.MyTask;

import java.util.ArrayList;

public class TasksRepository implements AutoCloseable{

    private final MyAPI api = new MyAPIImpl("http://localhost:63422");

    public ArrayList<Task> get() {
        var res = api.getMyTask();
        ArrayList<Task> tasks = new ArrayList<>();
        for(var x : res) {
            Task t = new Task(x.id());
            t.setTitle(x.title());
            t.setHighPriority(x.isHighPriority());
            t.setCompleted(x.isCompleted());
            tasks.add(t);
        }
        return tasks;
    }

    public void add(Task task) {
        MyTask t = new MyTask();
        t.withTitle(task.getTitle());
        t.withIsCompleted(task.isCompleted());
        t.withIsHighPriority(task.isHighPriority());
        api.postMyTask(t);
        EventChannel.publish();
    }

    public void edit(Task task) {
        MyTask t = api.getMyTask1(task.getId());
        t.withTitle(task.getTitle());
        t.withIsCompleted(task.isCompleted());
        t.withIsHighPriority(task.isHighPriority());
        api.putMyTask(task.getId(), t);
        EventChannel.publish();
    }

    public void setCompleted(int id) {
        MyTask task = api.getMyTask1(id);
        task.withIsCompleted(true);
        api.putMyTask(id, task);
        EventChannel.publish();
    }

    public void setNotCompleted(int id) {
        MyTask task = api.getMyTask1(id);
        task.withIsCompleted(false);
        api.putMyTask(id, task);
        EventChannel.publish();
    }

    public void delete(int id) {
        api.deleteMyTask(id);
        EventChannel.publish();
    }


    //  constructor
    public TasksRepository() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://192.168.99.100:1401;databaseName=TaskManagerDB;user=sa;password=admin@123";
    }

    @Override
    public void close() {

    }
}
