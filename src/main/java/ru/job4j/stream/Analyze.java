package ru.job4j.stream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .mapToInt(s -> s.getScore()).average().orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(),
                p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .average()
                        .orElse(0D))).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.averagingDouble(p -> p.getScore())))
                .entrySet().stream()
                .map((k) -> new Tuple(k.getKey(), k.getValue())).collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(),
                p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.summingDouble(p -> p.getScore())))
                .entrySet().stream()
                .map((k) -> new Tuple(k.getKey(), k.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}