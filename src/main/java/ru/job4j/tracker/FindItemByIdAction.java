package ru.job4j.tracker;

public class FindItemByIdAction  implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id===");
        int id = input.askInt("Enter id to find:");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("Заявка успешно найдена " + item);
        } else {
            out.println("Заявка не найдена.");
        }
        return true;
    }
}