package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();

        Set<String> set = new LinkedHashSet<>();
        String start;
        for (String dep : deps) {
            String[]  additDeps = dep.split("/");
            start = null;

            for (String subdep : additDeps) {
                if (start == null) {
                    start = subdep;
                } else {
                    start += "/" + subdep;
                }
                set.add(start);
            }

        }

        rsl.addAll(set);
        Collections.sort(rsl);

        return rsl;
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {

    }
}
