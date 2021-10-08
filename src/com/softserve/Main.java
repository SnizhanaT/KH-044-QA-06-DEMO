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

    static int getInt() {
        Integer option = null;
        while (option == null) {
            try {
                option = Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            }
        }
        return option;
    }

    static String getString() {
        return in.next();
    }

}
