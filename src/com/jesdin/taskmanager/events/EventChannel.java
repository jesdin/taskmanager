package com.jesdin.taskmanager.events;

import java.util.ArrayList;

public class EventChannel {

    private static ArrayList<ISubscriber> subscribers = new ArrayList<>();

    //methods
    public static void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public static void publish() {
        for (var e: subscribers) {
            e.updateData();
        }
    }
}
