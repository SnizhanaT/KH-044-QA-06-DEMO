package com.softserve.utils;

import java.util.Scanner;

public class ConsoleUtils {
    static Scanner in = new Scanner(System.in);

    public static int getInt() {
        Integer option = null;
        while (option == null) {
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter the number");
            }
        }
        return option;
    }

    public static String getString() {
        return in.nextLine();
    }
}
