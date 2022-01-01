package ru.job4j.tracker;

import java.awt.*;

public class Log4File {

    private static Log4File instance = null;
    private static String[] messages = new String[1000];
    private static int index = 0;

    private Log4File() {
    }

    public static Log4File getInstance() {
        if (instance == null) {
            instance = new Log4File();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public static void main(String[] args) {
        Log4File log = Log4File.getInstance();
        Log4File log1 = Log4File.getInstance();
        if (log == log1) {
            System.out.println("singleton");
        }
        log.add("add new Item");
    }
}
