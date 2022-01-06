package ru.job4j.tracker;

import java.util.List;

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
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            out.println("Найдены следующие заявки:" + items);
        } else {
            out.println("Заявки не найдены.");
        }
        return true;
    }
}
