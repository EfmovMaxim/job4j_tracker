package ru.job4j.lambda;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PredicateCheckPositive {
    public static boolean check(int num) {
        return check(a -> a > 0, num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }

    public static void main(String[] args) {
        List<String> str = List.of("bug");

        List<String> bugs = str.stream().filter(s -> s.contains("bug")).collect(Collectors.toList());
    }
}
