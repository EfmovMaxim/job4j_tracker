package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : list) {
            numbers.add(task.getNumber());
        }

        return numbers;
    }

    public static void main(String[] args) {

        System.out.println(FullSearch.extractNumber(List.of(new Task("111", "aaa"),
                new Task("111", "bbb"), new Task("222", "ccc"))));

    }
}
