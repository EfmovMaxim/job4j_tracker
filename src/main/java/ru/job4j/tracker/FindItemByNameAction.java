package ru.job4j.tracker;

import java.util.Arrays;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name===");
        String name = input.askStr("Enter name to find:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            out.println("Найдены следующие заявки:" + Arrays.toString(items));
        } else {
            out.println("Заявки не найдены.");
        }
        return true;
    }
}
