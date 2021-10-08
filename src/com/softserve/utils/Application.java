package com.softserve.utils;

import java.io.File;

import static com.softserve.utils.FileUtils.*;

public class Application {

    public static void main(String[] args) {
        createIfNotExists(taskFileName);
        readFile(taskFileName);

        createIfNotExists(deletedTaskFileName);
        readFile(deletedTaskFileName);
    }
}
