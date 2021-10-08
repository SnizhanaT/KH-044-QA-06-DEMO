package com.softserve.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends FileUtils {
    public static List<String> tasksList;
    public static List<String> deletedTasksList;

    public static void main(String[] args) {
        File taskFile = new File(taskFileName);
        if (taskFile.exists()) {
            System.out.println("Tasks file exists: " + taskFile.getName());
                readFile(taskFileName);
                System.out.println("File is not found");
        } else
            try {
                taskFile.createNewFile();
                List<String> tasksList = new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File deletedTaskFile = new File(deletedTaskFileName);
            if (deletedTaskFile.exists()) {
                System.out.println("Deleted tasks file exists: " + deletedTaskFile.getName());
                readFile(deletedTaskFileName);
            } else
                try {
                    deletedTaskFile.createNewFile();
                    List<String> deletedTasksList = new ArrayList<>();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }
