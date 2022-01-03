package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> account = new HashMap<>();
        account.put("11@ya.ru", "Ivanov Ivan");
        account.put("22@ya.ru", "Petrov Petr");

        for (Map.Entry<String, String> entry : account.entrySet()) {
            System.out.println(entry);
        }

    }
}
