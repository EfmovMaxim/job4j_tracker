package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenKvFunctionThenKvResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowFunctionThenPowResults() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(3D, 5D, 9D);
        assertThat(result, is(expected));
    }
}