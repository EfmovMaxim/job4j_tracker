package ru.job4j.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> compDesc = (left, right) -> {
            System.out.println("Compare:" + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };
        List<String> list = Arrays.asList("bug1", "bug111", "bug11");
        list.sort(compDesc);
        System.out.println(list);
    }
}
