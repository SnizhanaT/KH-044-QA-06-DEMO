package com.softserve.utils;

import com.softserve.Task;

import java.time.LocalDateTime;
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
        if (tasksList.isEmpty()) {
            System.out.println("Task list is empty. Back to main menu");
            return;
        }


        System.out.println("Enter task index to edit:");
        int taskIndex = getInt();
        while (taskIndex < 0 || taskIndex >= tasksList.size()) {
            System.out.println("Please enter correct index");
            taskIndex = getInt();
        }
        System.out.println("Task index " + taskIndex);

        Task task = tasksList.get(taskIndex);
        System.out.println("Select how to edit:");
        System.out.println("0 - Go back to main menu");
        System.out.println("1 - Update all fields");
        System.out.println("2 - Update title");
        System.out.println("3 - Update type");
        System.out.println("4 - Update priority");

        int option = getInt();
        while (option < 0 || option > 4) {
            System.out.println("Please enter correct option");
            option = getInt();
        }

        switch (option) {
            case 0:
                System.out.println("Back to main menu");
                break;
            case 1:
                System.out.println("Task: " + task.toString());
                System.out.println("Enter title");
                String title = getString();
                System.out.println("Enter type");
                String type = getString();
                System.out.println("Enter priority");
                int priority = getInt();
                task.setTitle(title);
                task.setType(type);
                task.setPriority(priority);
                System.out.println("Task with index " + taskIndex + " was updated.");
                break;
            case 2:
                System.out.println("Task title: " + task.getTitle());
                System.out.println("Enter title");
                String t = getString();
                task.setTitle(t);
                System.out.println("Task title was updated.");
                break;
            case 3:
                System.out.println("Task type: " + task.getType());
                System.out.println("Enter type");
                String tp = getString();
                task.setType(tp);
                System.out.println("Task type was updated.");
                break;
            case 4:
                System.out.println("Task priority: " + task.getPriority());
                System.out.println("Enter priority");
                int p = getInt();
                task.setPriority(p);
                System.out.println("Task priority was updated.");
                break;
            default:
                System.out.println("Invalid option");
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

        tasksList.add(new Task("asd", "asd", 432, LocalDateTime.now()));
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
