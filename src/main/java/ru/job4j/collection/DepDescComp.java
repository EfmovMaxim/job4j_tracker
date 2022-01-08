package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String dep1, String dep2) {
        int rsl;

        String[] dep1Str   = dep1.split("/");
        String[] dep2Str   = dep2.split("/");

        rsl = dep2Str[0].compareTo(dep1Str[0]);
        if (rsl == 0) {
            rsl = dep1.compareTo(dep2);
        }

        return rsl;

//        int minLength = Math.min(dep1Str.length, dep2Str.length);
//
//        for (int i = 0; i < minLength; ++i) {
//
//            if (i == 0) {
//                rsl = dep2Str[i].compareTo(dep1Str[i]);
//            } else {
//                rsl = dep1Str[i].compareTo(dep2Str[i]);
//            }
//
//            if (rsl != 0)  {
//                return rsl;
//            }
//        }
//
//        return Integer.compare(dep1Str.length, dep2Str.length);
    }
}
