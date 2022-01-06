package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemReverseSort;
import ru.job4j.tracker.Tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));

        }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 10; i++) {
            Item bug = new Item();
            bug.setName("Bug" + i);
            tracker.add(bug);
        }

        int id = 3;
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 10; i++) {
            Item bug = new Item();
            bug.setName("Bug" + i);
            tracker.add(bug);
        }

        int id = 3;
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenSortItems() {
        ArrayList<Item> items = new ArrayList<>();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        items.add(third);
        items.add(second);
        items.add(first);

        Collections.sort(items);

        List<Item> expected = List.of(first, second, third);

        assertThat(items, is(expected));

    }

    @Test
    public void whenReverseSortItems() {
        ArrayList<Item> items = new ArrayList<>();
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");

        items.add(second);
        items.add(third);
        items.add(first);

        Collections.sort(items, new ItemReverseSort());

        List<Item> expected = List.of(third, second, first);

        assertThat(items, is(expected));

    }

}