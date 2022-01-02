package ru.job4j.tracker.collection;

import java.util.HashSet;
import java.util.List;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");

        HashSet<String> check = new HashSet<>();

        check.addAll(List.of(origin));

        for (String word : text) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(UniqueText.isEquals("Мы делаем дома и коттеджи", "Мы делаем коттеджи и дома"));
    }
}
