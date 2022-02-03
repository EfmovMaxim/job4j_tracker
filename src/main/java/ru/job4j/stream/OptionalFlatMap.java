package ru.job4j.stream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFlatMap {
    public static Optional<Integer> stringLength(List<String> strings) {
        return strings.stream()
                .filter(s -> s.endsWith(".java"))
                .map(s -> s.length())
                .findFirst();
    }
}