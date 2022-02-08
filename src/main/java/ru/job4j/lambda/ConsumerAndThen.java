package ru.job4j.lambda;

import java.util.function.Consumer;

public class ConsumerAndThen {
    public static Consumer<String> consumer(String input) {

        Consumer<String> c1 = System.out::print;
        Consumer<String> c2 = s -> System.out.println();

        return c1.andThen(c2);
    }
}
