package com.softserve.utils;

import com.softserve.Task;

import java.io.File;
import java.util.List;

import static com.softserve.utils.ConsoleUtils.getInt;
import static com.softserve.utils.ConsoleUtils.getString;
import static com.softserve.utils.FileUtils.*;

public class Application {
    public static List<Task> tasksList;
    public static List<Task> deletedTasksList;

    static void createTask() {
        //todo delete this method
        System.out.println("Choose way of creating. Enter number: 1 - fast way in one line, 2 - usual way step by step.");
        int priority = getInt();
        if (priority == 1) {
            createTaskFastWay();
        } if (priority == 2) {
            createTaskUsualWay();
        }
    }
// TODO delete under
static void createTaskFastWay() {
    System.out.println("For creating task enter data according to this pattern, please! Using  \"!\"");
    System.out.println("Task title!Personal or Work or Household!number of priority: (1 -High, 2 - Medium, 3 - Low)!date time mm-dd-yyyy hh:mm");
    String fastWay = getString();
    System.out.println("Confirm this task:" + fastWay);
    //scanner.close();
    //show task and confirm
    // save task
    System.out.println("Task successfully created");
}


    static void createTaskUsualWay() {
        System.out.println("For creating task enter task title, please!");
        String title = getString();
        System.out.println("Enter a type of task, please: Personal or Work or Household.");
        String type = getString();
        System.out.println("Enter task priority");
        System.out.println("Choose task priority and write number of it, please:");
        System.out.println("1 -High, 2 - Medium, 3 - Low");
        int priority = getInt();
        System.out.println("Enter date and time mm-dd-yyyy hh:mm.");
        String dateTime = getString();
        System.out.println("Confirm this task:" + title + type + priority + dateTime);
        //scanner.close();
        //show task and confirm
        // save task
        System.out.println("Task successfully created");
    }
    //TODO delete above
    static void editTask() {
        //TO DO
    }

    static void deleteTask() {
        //TO DO
    }

    static void viewTasks() {
        System.out.println("For viewing tasks choose option, please!");
        System.out.println("1 -View all your tasks");
        System.out.println("2- View deleted tasks");
        System.out.println("3- Input id to view tasks. You can find ID by entering 1");
        System.out.println("4- Sort tasks");
        System.out.println("-1 - Enter \"minus one\" to go back to home menu");
        int optional = getInt();
        switch (optional) {
            case 1:
                //show all tasks
               // getTaskDescription();
                //    (при выводе надо будет выводить id (index из List<Task) для удаления


            case 2:
                //show deleted tasks

            case 3:
                //input id to view tasks

            case 4:
                System.out.println("For viewing sorted tasks choose option, please!");
                //if sort tasks - use loop
                //////1 sorting from erliet to late time //opt?
                //////1 - on the concrete day   // end - start // string int?
                //////2- period of time from... to.. (week , month)
                //2 - by priority (first data, than priority)? opt<
                ///////1 - all by priority from important to less improtant
                ///////1 - all by priority from less important to impertant
                //////3 - only chosen priority
                //3- by tipe (first data, than priority)? opt<
                //4 - by title or world // methodth containts
                //5- by time
                //-1 - back
            case -1:
                System.out.println("-1 - Enter \"minus one\" to go back to home menu"); //Todo
                break;
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
