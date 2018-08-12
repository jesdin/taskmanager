package com.jesdin.taskmanager.models;

public class Task {

    // private fields
    private String title;
    private boolean isHighPriority;
    private boolean isCompleted = false;

    //constructor
    public Task(String title, boolean HighPriority) {
        setTitle(title);
        setHighPriority(HighPriority);
    }

    // public properties
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHighPriority() {
        return isHighPriority;
    }

    public void setHighPriority(boolean highPriority) {
        isHighPriority = highPriority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}