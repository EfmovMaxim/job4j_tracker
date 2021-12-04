package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {

        return Arrays.copyOf(items, size);

    }

    public Item findById(int id) {
        int index = indexOf(id);
        return  index != -1 ?items[index] : null;
    }

    public Item[] findByName (String key) {
        Item[] rsl = new Item[size];
        int i = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[i] = item;
                i++;
            }
        }
        return Arrays.copyOf(rsl, i);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);

        if (index != -1) {
            int oldId = items[index].getId();
            item.setId(oldId);
            items[index] = item;
            return true;
        } else return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
           items[index] = null;
           System.arraycopy(items, index + 1, items, index, size - index - 1);
           size--;
           return true;
        } else return false;

    }

}