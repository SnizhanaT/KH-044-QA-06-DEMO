package com.softserve.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends FileUtils {
    public static final String taskFileName = "tasks.txt";
    public static final String deletedTaskFileName = "deletedTasks.txt";

    public static void main(String[] args) {
        File taskFileName = new File(path);
        if (taskFileName.exists()) {
            System.out.println("Tasks file exists: " + taskFileName.getName());
            try {
                readFile(path);
            } catch (FileNotFoundException e) {
                System.out.println("File is not found");
            }
        } else
            try {
                taskFileName.createNewFile();
                List<String> tasksList = new ArrayList<>();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File deletedTaskFileName = new File(path);
            if (deletedTaskFileName.exists()) {
                System.out.println("Deleted tasks file exists: " + deletedTaskFileName.getName());
                try {
                    readFile(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else
                try {
                    deletedTaskFileName.createNewFile();
                    List<String> deletedTasksList = new ArrayList<>();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }
