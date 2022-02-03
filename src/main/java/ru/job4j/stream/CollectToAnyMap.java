package ru.job4j.stream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class CollectToAnyMap {

    public static Map<Integer, Integer> collect(Stream<Integer> data) {
        //return data.collect(Collectors.toMap(i -> i, i -> i * i, (l, r) -> l, LinkedHashMap::new));
        //return data.collect(Collector.of( , , ));
        return new HashMap<>();
    }
}