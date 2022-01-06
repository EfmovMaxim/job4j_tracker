package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

       String[] numLeft = left.split(". ", 2);
       String[] numRight = right.split(". ", 2);

       int num1 = Integer.parseInt(numLeft[0]);
       int num2 = Integer.parseInt(numRight[0]);

       return Integer.compare(num1, num2);
    }
}
