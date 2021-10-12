package com.softserve.utils;

import com.softserve.Task;

import java.util.List;

import static com.softserve.utils.ConsoleUtils.getInt;
import static com.softserve.utils.ConsoleUtils.getString;
import static com.softserve.utils.FileUtils.*;

public class Application {
    public static List<Task> tasksList;
    public static List<Task> deletedTasksList;

    static void createTask() {
        //TO DO
    }

    static void editTask() {
        System.out.println("This is edit task menu");
        System.out.println("Enter task id to edit:");
        int taskId = getInt();
        System.out.println("Task " + taskId);
        Task task = null;
        for (int i = 0; i < tasksList.size(); i++) {
            Task t = tasksList.get(i);
            if(t.getId() == taskId) {
                task = t;
            }
        }
        if(task == null) {
            System.out.println("Task with id " +taskId + " not found.");
        } else {
            System.out.println("Enter title");
            String title = getString();
            System.out.println("Enter type");
            String type = getString();
            System.out.println("Enter priority");
            int priority = getInt();
            task.setTitle(title);
            task.setType(type);
            task.setPriority(priority);
            task.setDateTime(); // дату обновить?
            System.out.println("Task with id " +taskId + " was updated.");
        }
    }

    static void deleteTask() {
        //TO DO
    }

    static void viewTasks() {
        //TO DO
    }

    public static void main(String[] args) {
        createIfNotExists(taskFileName);
        tasksList = readFile(taskFileName);

        createIfNotExists(deletedTaskFileName);
        readFile(deletedTaskFileName);

        int option = 1;
        while (option != 0) {
            System.out.println("Main menu. Choose option:");
            System.out.println("1 - Create task");
            System.out.println("2 - Edit task");
            System.out.println("3 - Delete task");
            System.out.println("4 - View tasks");
            System.out.println("0 - Exit");
            option = getInt();
            switch (option) {
                case 1:
                    createTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    viewTasks();
                    break;
                case 0:
                    System.out.println("Good bye");
            }
        }
    }
}
