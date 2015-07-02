package com.springapp.mvc.event;

public class EventCustom {

    private int type;

    private String message;

    private long threadId;

    public EventCustom(int type, String message) {
        this.type = type;
        this.message = message;
        this.threadId = Thread.currentThread().getId();
    }

    public String toString() {
        return "event type : " + type + " message : " + message + " threadId : " + threadId;
    }

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public long getThreadId() {
        return threadId;
    }
}
