package ru.job4j.tracker;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Item item = new Item();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(format));
    }
}
