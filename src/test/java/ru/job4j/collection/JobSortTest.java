package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JobSortTest {

    @Test
    public void whenSortByName() {
        Job first = new Job("First", 1);
        Job second = new Job("Second", 2);
        Job third = new Job("Third", 3);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobByName());

        List<Job> expected = List.of(first, second, third);

        assertThat(jobs, is(expected));
    }

    @Test
    public void whenReverseSortByName() {
        Job first = new Job("First", 1);
        Job second = new Job("Second", 2);
        Job third = new Job("Third", 3);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobDescByName());

        List<Job> expected = List.of(third, second, first);

        assertThat(jobs, is(expected));
    }

    @Test
    public void whenSortByPriority() {
        Job first = new Job("First", 2);
        Job second = new Job("Second", 3);
        Job third = new Job("Third", 1);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobByPriority());

        List<Job> expected = List.of(third, first, second);

        assertThat(jobs, is(expected));
    }

    @Test
    public void whenReverseSortByPriority() {
        Job first = new Job("First", 2);
        Job second = new Job("Second", 3);
        Job third = new Job("Third", 1);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobDescByPriority());

        List<Job> expected = List.of(second, first, third);

        assertThat(jobs, is(expected));
    }

    @Test
    public void whenSortByNameAndPriority() {
        Job first = new Job("First", 1);
        Job second = new Job("First", 2);
        Job third = new Job("Third", 3);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobByName().thenComparing(new JobByPriority()));

        List<Job> expected = List.of(first, second, third);

        assertThat(jobs, is(expected));
    }

    @Test
    public void whenReverseSortByNameAndPriority() {
        Job first = new Job("First", 1);
        Job second = new Job("First", 2);
        Job third = new Job("Third", 3);

        List<Job> jobs = Arrays.asList(second, first, third);
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));

        List<Job> expected = List.of(third, second, first);

        assertThat(jobs, is(expected));
    }

}