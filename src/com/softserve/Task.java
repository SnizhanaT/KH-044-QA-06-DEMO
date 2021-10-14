package com.softserve;

import com.softserve.utils.DateUtils;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String type;
    private int priority;
    private LocalDateTime dateTime;
    private LocalDateTime deletedDateTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String types) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDeletedDateTime() {
        return deletedDateTime;
    }

    public void setDeletedDateTime() { this.deletedDateTime = deletedDateTime; }

    public Task(String title, String types, int priority, LocalDateTime dateTime) {
        this.title = title;
        this.type = types;
        this.priority = priority;
        this.dateTime = dateTime;
    }

    public Task(String taskString) {
        String[] split = taskString.split("!");
        this.title = split[0];
        this.type = split[1];
        this.priority = Integer.parseInt(split[2]);
        this.dateTime = DateUtils.parseFromString(split[3]);
        this.deletedDateTime = (split[4] != null) ? DateUtils.parseFromString(split[4]) : null;

    }

    public void printTaskDescription() {
        System.out.println("Task title: " + title);
        System.out.println("Task type: " + type);
        System.out.println("Priority: " + priority);
        System.out.println("Date and Time: " + dateTime);
        if (deletedDateTime != null) {
            System.out.println("Deleted date and time: "+deletedDateTime);
        }
    }

    public String toString() {
        return title + "!" + type + "!" + priority + "!" + DateUtils.dateTimeToString(dateTime) + "!"
                + ((deletedDateTime != null) ? DateUtils.dateTimeToString(deletedDateTime) : null );
    }
}
