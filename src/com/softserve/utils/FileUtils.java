package com.softserve.utils;

import com.softserve.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static final String taskFileName = "tasks.txt";
    public static final String deletedTaskFileName = "deletedTasks.txt";


    public static void writeFile(String taskFileName, List<Task> tasks) {
        try {
            FileWriter fileWriter = new FileWriter(taskFileName);
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                fileWriter.write(task.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> readFile(String taskFileName) {
        List<Task> tasks = new ArrayList<>();
        try {
            File file = new File(taskFileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                tasks.add(new Task(scanner.nextLine()));
            }
            scanner.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return tasks;
    }

    public static void createIfNotExists(String taskFileName) {
        try {
            File file = new File(taskFileName);
            file.createNewFile();
            List<String> List = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


