package com.softserve.utils;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static String path = "tasks.txt";
    public static String text;

    public static void writeFile(String path, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(text);
        fileWriter.close();
    }

    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.hasNextLine());
        }
        scanner.close();
    }
}


