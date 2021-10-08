package com.softserve;

public class Task {
    private String title;
    private String type;
    private int priority;
    //private LocalDateTime dateTime;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getType(){
        return type;
    }

    public void setType(String types){
        this.type = type;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    /*public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(){
        this.dateTime = dateTime;
    }*/

    public Task(String title, String types, int priority/*LocalDateTime dateTime*/){
        this.title = title;
        this.type = types;
        this.priority = priority;
        //this.dateTime = dateTime;
    }
    public Task(String taskString){
      String[] split = taskString.split(" ");
      this.title = split [0];
      this.type = split [1];
      this.priority = Integer.parseInt(split[2]);
    }
    public void getTaskDescription(){
        System.out.println("Task title: " + title);
        System.out.println("Task type: " + type);
        System.out.println("Priority: " + priority);
    }
    public String toSrting(){
        return title + " " + type + " " + priority;
    }
    public static void main (String[]args){
        Task task1 = new Task ("Title Type 3");
        System.out.println(task1.toSrting());
    }


}
