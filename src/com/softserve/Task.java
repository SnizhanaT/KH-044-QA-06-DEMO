package com.softserve;

import com.softserve.utils.DateUtils;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String type;
    private int priority;
    private LocalDateTime dateTime;
    private LocalDateTime deletedTime;


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


    public void setDateTime(LocalDateTime dateTime) { //check with localDateTime
        this.dateTime = dateTime;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }

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
        this.deletedTime = (deletedTime != null) ? DateUtils.parseFromString(split[4]) : null;
    }


    public String getPrintTaskDescription() {
        String description = "Task title: " + title + "Task type: " + type + "Priority: " + priority + "Date and Time: " + dateTime ;
        if (deletedTime != null) {
            description = description + "Deleted Date and Time: " + deletedTime;
        }
        return description;
    }


    public String toString() {
        return title + "!" + type + "!" + priority + "!" + DateUtils.dateTimeToString(dateTime) + "!"
                + ((deletedTime != null) ? DateUtils.dateTimeToString(deletedTime) : null);
    }
   

}

