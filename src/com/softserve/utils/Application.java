package com.softserve.utils;

import com.softserve.Task;

import java.io.File;
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
        //TO DO;
    }

    static void deleteTask() {
        System.out.println("This is delete task menu \nChoose option: ");
        System.out.println("1 - Choose task that needs to be deleted");
        System.out.println("-1 - Go back to main menu");
        int option = getInt();
        switch (option) {
            case 1:
                System.out.println("View tasks and input id of the task that needs to be deleted:");
                for (Task task : tasksList) {
                    System.out.println(task);
                }
                //юзер сам буде рахувати індекс по виведеним рядкам чи як нам показати юзеру індекси
                int taskId = getInt();
                System.out.println("Deleting task " + tasksList.get(taskId));
                tasksList.remove(taskId);
                LocalDateTime deletedDateTime = LocalDateTime.now();
                System.out.println("Successfully deleted");
                writeFile(taskFileName, tasksList);

                //deletedTasksList.add(deletedtask); - як нам знайти видалений таск тепер
                //writeFile(deletedTaskFileName, deletedTasksList);

            case 2:
                // go back to main menu(how?)
        }
    }

    static void viewTasks() {
        //TO DO
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

