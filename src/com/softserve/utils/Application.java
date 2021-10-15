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
        Task task = null;
        System.out.println("Choose way of creating. Enter number:\n" +
                "1 - Fast way - in one line\n" +
                "2 - Usual way - step by step\n" +
                "-1 - Go back to main menu");

        int option = ConsoleUtils.getInt();
        switch (option) {
            case 1:
                task = createTaskInOneLine();
                break;
            case 2:
                task = createTaskStepByStep();

                break;
            case -1:
                task = null;
                break;
        }
        if (task == null) {
            System.out.println("Go back to main menu");
        } else {
            tasksList.add(task);
            FileUtils.writeFile("tasks.txt", tasksList);
        }

    }


    public static Task createTaskInOneLine() {
        System.out.println("For creating task enter data according to this pattern, please!\n" +
                "Task construction:  Task title!type Personal or Work or Household!number of priority 1 - High, 2 - Medium, 3 - Low!datetime dd-MM-yyyy HH:mm\n" +
                "Task example: Come to the DEMO!Work!1!15-10-2021 19:00\n" +
                "-1 - Go back");
        String taskInOneLine = ConsoleUtils.getString();

        if (taskInOneLine.contains("!")) {
            System.out.println("Task successfully created");
        } else {
            return null;
        }
        return new Task(taskInOneLine);
    }


    public static Task createTaskStepByStep() {

        System.out.println("For creating task enter task title, please!\n" +
                "-1 - Go back");
        String title = ConsoleUtils.getString();
        if (title.equals("-1")) {
            return null;
        }
        System.out.println("Enter a type of task, please: Personal or Work or Household.\n" +
                "-1 - Go back");
        String type = ConsoleUtils.getString();
        if (type.equals("-1")) {
            return null;
        }
        System.out.println("Enter task priority. Choose task priority and write number of it, please: 1 -High, 2 - Medium, 3 - Low\n" +
                "-1 - Go back");
        int priority = ConsoleUtils.getInt();
        if (priority == -1) {
            return null;
        }
        System.out.println("Enter date and time dd-MM-yyyy HH:mm.\n" +
                "-1 - Go back");
        String dateTime = ConsoleUtils.getString();
        if (dateTime.equals("-1")) {
            return null;

        }
        LocalDateTime localDateTime = DateUtils.parseFromString(dateTime);
        System.out.println("Task successfully created!");
        return new Task(title, type, priority, localDateTime);

    }


    static void editTask() {
        System.out.println("This is edit task menu");
        if (tasksList.isEmpty()) {
            System.out.println("Task list is empty. Back to main menu");
            return;
        }
        System.out.println("View tasks list and choose the id of task for editing :");
        for (int i = 0; i < tasksList.size(); i++) {
            System.out.println("tasks id : " + i);
            // tasksList.get(i).getPrintTaskDescription();
            System.out.println(tasksList.get(i));
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
        System.out.println("This is delete task menu.");
        int option;
        do {
            System.out.println("Choose option: \n1 - Choose task that needs to be deleted \n-1 - Go back to main menu");
            option = getInt();
        }
        while (option != 1 & option != -1);

        switch (option) {
            case 1:
                System.out.println("View tasks and input id of the task that needs to be deleted:");
                for (int i = 0; i < tasksList.size(); i++) {
                    System.out.println("Task id: " + i);
                    System.out.println(tasksList.get(i));
                }
                int taskIndex;
                do {
                    System.out.println("Input task id");
                    taskIndex = getInt();
                }
                while (taskIndex >= tasksList.size() & taskIndex <= 0);

                Task deletedTask = tasksList.remove(taskIndex);
                deletedTask.setDeletedTime(LocalDateTime.now());
                writeFile(deletedTaskFileName, deletedTasksList);
                deletedTasksList.add(deletedTask);
                writeFile(taskFileName, tasksList);
                System.out.println("Successfully deleted! Back to main menu.");
                break;
            case -1:
                System.out.println("Go back to main menu");
                break;
        }
    }

    static void viewTasks() {
        int option;
        System.out.println("For viewing tasks choose option, please!");
        System.out.println("1 -View number of  your all tasks");
        System.out.println("2- View list of you actual task with ID");
        System.out.println("3- Input id to view tasks. ");
        System.out.println("4- View tasks in range between two task ID");
        System.out.println("5- View deleted tasks");
        System.out.println("-1 - Enter \"minus one\" to go back to home menu");
        option = getInt();

        switch (option) {
            case 1:
                System.out.println("Total number of actual tasks is: " + tasksList.size());
                System.out.println("Total number of deleted tasks is: " + deletedTasksList.size());
                System.out.println("Total number of all your tasks is: " + (Integer.valueOf(tasksList.size()) +
                        Integer.valueOf((deletedTasksList.size()))));
                break;
            case 2:
                boolean ifEmptyTaskList = tasksList.isEmpty();
                System.out.println(tasksList.isEmpty());
                if (ifEmptyTaskList == true) {
                    System.out.println("You don't have any task");
                } else {
                    for (int i = 0; i < tasksList.size(); i++) {
                        System.out.println("tasks id : " + i);
                        System.out.println(tasksList.get(i));
                    }
                }
                break;
            case 3:
                System.out.println("Enter id of task that you want to view");
                int indOfTask = getInt();
                tasksList.get(indOfTask);
                System.out.println(tasksList.get(indOfTask));
                break;
            case 4:
                System.out.println("View tasks in range between :");
                System.out.println("Enter task ID start of range ");
                int startTask = getInt();
                System.out.println("Enter task end of range not including (result will display in one line)");
                int endTask = getInt();
                if (endTask > tasksList.size()) try {
                    throw new Exception("The end number  is bigger than you have tasks");
                } catch (Exception e) {
                    System.out.println("You have less tasks");
                    e.printStackTrace();
                }
                System.out.println(tasksList.subList(startTask, endTask));
                break;
            case 5:
                //show deleted tasks
                boolean ifEmptyDeletedTaskList = deletedTasksList.isEmpty();
                if (ifEmptyDeletedTaskList == false) {
                    for (int i = 0; i < deletedTasksList.size(); i++) {
                        System.out.println("tasks id : " + i);
                        System.out.println(deletedTasksList.get(i));
                    }
                } else {
                    System.out.println("You don't have any deleted task");
                }
                break;
            case -1:
                System.out.println("You successfully came back to home menu");
                break;
        }
    }

    static void restoreTask() {
        System.out.println("This is restore task menu \nChoose option: ");
        int option;
        do {
            System.out.println("1 - Choose task that needs to be restored");
            System.out.println("-1 - Go back to main menu");
            option = getInt();
        }
        while (option != 1 & option != -1);

        switch (option) {
            case 1:
                System.out.println("View deleted tasks list and choose the id of task for restoring :");
                for (int i = 0; i < deletedTasksList.size(); i++) {
                    System.out.println("tasks id : " + i);
                    System.out.println(deletedTasksList.get(i));
                }
                int taskIndex;
                do {
                    System.out.println("Input task id :");
                    taskIndex = getInt();
                }
                while (taskIndex <= 0 & taskIndex >= deletedTasksList.size());

                Task restoredTask = deletedTasksList.remove(taskIndex);
                restoredTask.setDateTime(LocalDateTime.now());
                writeFile(taskFileName, tasksList);
                writeFile(deletedTaskFileName, deletedTasksList);
                tasksList.add(restoredTask);
                writeFile(taskFileName, tasksList);
                System.out.println("Successfully restored");
                break;
            case -1:
                System.out.println("Go back to main menu");
        }
    }


    public static void run() {
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


