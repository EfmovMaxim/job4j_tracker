package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(-1, 0, -5, 2));
        List<Integer> rsl = list.stream().filter(n -> n > 0).collect(Collectors.toList());
        rsl.stream().forEach(System.out::println);
    }
}
