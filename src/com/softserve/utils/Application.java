package com.softserve.utils;

import com.softserve.Task;

import java.io.File;
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
        //TO DO
    }

    static void deleteTask() {
        //TO DO
    }

    static void viewTasks() {
        //TO DO
    }

    static void restoreTask() {
        System.out.println("This is restore task menu \nChoose option: ");
        System.out.println("1 - Choose task that needs to be restored");
        System.out.println("-1 - Go back to main menu");
        int option = getInt();
        switch (option) {
            case 1:
                System.out.println("View tasks and input id of the task that needs to be restored:");
                for (Task delTask : deletedTasksList) {
                    System.out.println(delTask);
                }
                int taskId = getInt();
                System.out.println("Restore the task " + deletedTasksList.get(taskId));
                deletedTasksList.remove(taskId);
                writeFile(deletedTaskFileName, deletedTasksList);
                LocalDateTime deletedDateTime = LocalDateTime.now();
                System.out.println("Successfully restored");
                break;
            case 2:


        }
    }

    public static void main(String[] args) {
        createIfNotExists(taskFileName);
        readFile(taskFileName);

        createIfNotExists(deletedTaskFileName);
        readFile(deletedTaskFileName);

        int option = 1;
        while (option != 0) {
            System.out.println("Main menu. Choose option:");
            System.out.println("1 - Create task");
            System.out.println("2 - Edit task");
            System.out.println("3 - Delete task");
            System.out.println("4 - View tasks");
            System.out.println("5 - Restore task");
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
                case 5:
                    restoreTask();
                    break;
                case 0:
                    System.out.println("Good bye");
            }
        }
    }
}
