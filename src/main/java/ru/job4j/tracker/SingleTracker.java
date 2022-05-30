package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker extends MemTracker {
    private static MemTracker tracker = new MemTracker();
    private static SingleTracker instance;

    private SingleTracker() {
    }

    public static SingleTracker getTracker() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    @Override
    public Item add(Item item) {
        return tracker.add(item);
    }

    @Override
    public List<Item> findAll() {
        return tracker.findAll();
    }

    @Override
    public Item findById(int id) {
        return tracker.findById(id);
    }

    @Override
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    @Override
    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    @Override
    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
