package com.softserve;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static boolean run = true;


    static void chooseFirstOptions() {
        System.out.println("Hello! Welcome to your organizer!");
        while (run = true) {
            System.out.println("Main menu. Choose option and write number of it, please:");
            System.out.println("1 - Create task");
            System.out.println("2 - Edit task");
            System.out.println("3 - Delete task");
            System.out.println("4 - View tasks");
            System.out.println("0 - Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Choose way of creating. Enter number: 1 - fast way in one line, 2 - usual way step by step.");
                    int priority = getInt();
                    if (priority == 1) {
                        createTaskFastWay();
                    } if (priority == 2) {
                    createTaskUsualWay();
                }
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
                    System.out.println("Good bye! See you soon!");
                    run = false;
                    break;
            }
        }
    }


    static void createTaskFastWay() {
        System.out.println("For creating task enter data according to this pattern, please!");
        System.out.println("Task title_Personal or Work or Household_number of priority: 1 -High, 2 - Medium, 3 - Low_date_time");
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
        System.out.println("Enter date and time mm-dd-yyyy_hh:mm.");
        String dateTime = getString();
        System.out.println("Confirm this task:" + title + type + priority + dateTime);
        //scanner.close();
        //show task and confirm
        // save task
        System.out.println("Task successfully created");
    }

    static void editTask() {
        System.out.println("For editing your task.");
        System.out.println("Enter task id");
        int id = getInt();
        //show task
        //choose what field you would like to edit
        System.out.println("Enter task title");
        String title = getString();
        System.out.println("Enter task type");
        String type = getString();
        System.out.println("Enter task priority");
        int priority = getInt();

        System.out.println("Task successfully edited");
    }

    static void deleteTask() {
        System.out.println("This is delete task menu.");
        System.out.println("Enter task id");
        int id = getInt();

        System.out.println("Task successfully deleted");
    }

    static void viewTasks() {
        System.out.println("This is view task menu.");

        // show task
        System.out.println("Task is displayed");
    }

    static int getInt() {
        Integer option = null;
        while (option == null) {
            try {
                option = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            }
        }
        return option;
    }


    static String getString() {
        String s = scanner.next();
        return s;
    }

}
