package com.softserve.utils;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static String path = "tasks.txt";
    public static String text;
    public static final String taskFileName = "tasks.txt";
    public static final String deletedTaskFileName = "deletedTasks.txt";


    public static void writeFile(String path, List<String> Tasks) {
         try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.hasNextLine());
            }
            scanner.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    // create newFile винести сюди
}


