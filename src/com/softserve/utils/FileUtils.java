package com.softserve.utils;

import com.softserve.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.softserve.utils.Application.tasksList;

public class FileUtils {

    public static final String taskFileName = "tasks.txt";
    public static final String deletedTaskFileName = "deletedTasks.txt";


    public static void writeFile(String taskFileName, List<Task> tasks) { //Юля перпеписує цей метод
         try {
            FileWriter fileWriter = new FileWriter(taskFileName);
            fileWriter.write(String.valueOf(tasks));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> readFile(String taskFileName) { //Юля переписує цей метод
        try {
            File file = new File(taskFileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.hasNextLine());
            }
            scanner.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return tasksList;
    }

    public static void createIfNotExists(String taskFileName) {
        try {
            File file = new File(taskFileName);
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


