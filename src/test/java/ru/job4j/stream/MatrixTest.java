package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void convertMatrixToList() {

        Integer[][] matrix = {{1, 2}, {3, 4}};
        Matrix converter = new Matrix();
        List<Integer> rsl = converter.convertMatrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        Assert.assertThat(rsl, is(expected));

    }
}