package ru.job4j.stream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeMethod {
    public static IntStream createStream(int start, int end) {
        return IntStream.rangeClosed(start, end);
    }

    public static void main(String[] args) {
        System.out.println(createStream(7, 22).boxed().collect(Collectors.toList()));
    }

    }

