package ru.job4j.collection;

import javax.management.ObjectInstance;
import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        System.out.println(groups);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {

            array[row][cell] = num;
            if (cell == cells - 1) {
                cell = 0;
                row++;
            }   else {
                cell++;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.printf("  %d", cell);
            }
            System.out.println();
        }
    }

}
