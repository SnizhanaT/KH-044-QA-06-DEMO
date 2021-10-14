package com.softserve.utils;

import com.softserve.Task;

import java.time.LocalDateTime;
import java.util.List;

import static com.softserve.utils.ConsoleUtils.getInt;
import static com.softserve.utils.FileUtils.*;

public class Application {
    public static List<Task> tasksList;
    public static List<Task> deletedTasksList;

    static void createTask() {
        //TO DO
    }

    static void editTask() {
        //TO DO;
    }

    static void deleteTask() {
        System.out.println("This is delete task menu \nChoose option: ");
        System.out.println("1 - Choose task that needs to be deleted \n-1 - Go back to main menu");
        int option = getInt();
        if (option != 1 && option != -1) {
            System.out.println("Choose only 1 or -1");
        }
            switch (option) {
                case 1:
                    System.out.println("View tasks and input id of the task that needs to be deleted:");
                    for (int i = 0; i < deletedTasksList.size(); i++) {
                        System.out.println("Task id: " + i);
                        deletedTasksList.get(i).printTaskDescription();
                    }
                    int taskIndex = getInt();
                    System.out.println("Deleting task " + tasksList.get(taskIndex));
                    Task deletedTask = tasksList.remove(taskIndex);
                    deletedTask.setDeletedDateTime();
                    System.out.println("Successfully deleted");
                    writeFile(deletedTaskFileName, deletedTasksList);
                    tasksList.add(deletedTask);
                    writeFile(taskFileName, tasksList);
                    break;
                case -1:
                    System.out.println("Go back to main menu");
                    break;
                default:
                    System.out.println("Invalid option");
            }
    }

    static void viewTasks() {
        //TO DO
    }

    public static void main(String[] args) {
        createIfNotExists(taskFileName);
        tasksList = readFile(taskFileName);

        createIfNotExists(deletedTaskFileName);
        deletedTasksList = readFile(deletedTaskFileName);

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

