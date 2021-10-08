package com.softserve.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.utils.FileUtils.*;

public class Application {

    public static void main(String[] args) {
        File taskFile = new File(taskFileName);
        if (taskFile.exists()) {
            System.out.println("Tasks file exists: " + taskFile.getName());
                readFile(taskFileName);
        } else createIfNotExists(taskFileName);

            File deletedTaskFile = new File(deletedTaskFileName);
            if (deletedTaskFile.exists()) {
                System.out.println("Deleted tasks file exists: " + deletedTaskFile.getName());
                readFile(deletedTaskFileName);
            } else createIfNotExists(deletedTaskFileName);
            }
    }
