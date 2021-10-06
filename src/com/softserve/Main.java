package com.softserve;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

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

    static void createTask() {

        System.out.println("\nThis is create task menu.");
        System.out.println("Enter task title");
        String title = getString();
        System.out.println("Enter task type");
        String type = getString();
        System.out.println("Enter task priority");
        int priority = getInt();

        // create and save task
        System.out.println("Task was created");
    }

    static void editTask() {
        System.out.println("\nThis is edit task menu.");
        System.out.println("Enter task id");
        int id = getInt();
        System.out.println("Enter task title");
        String title = getString();
        System.out.println("Enter task type");
        String type = getString();
        System.out.println("Enter task priority");
        int priority = getInt();

        // get task and update
        System.out.println("Task was updated");
    }

    static void deleteTask() {
        System.out.println("\nThis is delete task menu.");
        System.out.println("Enter task id");
        int id = getInt();

        // delete
        System.out.println("Task was deleted");
    }

    static void viewTasks() {
        System.out.println("\nThis is view task menu.");

        // show tasks
        System.out.println("Task are  here");
    }

    static int getInt() {
        Integer option = null;
        while (option == null) {
            try {
                option = Integer.parseInt(in.next());
            } catch (Exception e) {
                System.out.println("Enter the number");
            }
        }
        return option;
    }

    static String getString() {
        String s = null;
        while (s == null || s.length() == 0) {
            try {
                s = in.next();
            } catch (Exception e) {
                System.out.println("Enter the field");
            }
        }
        return s;
    }

}
