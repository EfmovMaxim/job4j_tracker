package ru.job4j.tracker.collection;

import java.util.ArrayList;

public class UsageArrayList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "Petr");
        list.add(0, "Ivan");
        list.add(0, "Stepan");
        list.add(0, null);

        list.trimToSize();
        //list.set(1, "ii");
        for (String name: list) {
            System.out.println(name);
        }
        System.out.println(list.size());
    }
}
