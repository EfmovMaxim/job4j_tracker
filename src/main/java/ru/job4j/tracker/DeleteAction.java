package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("Enter id to delete:");
        if (tracker.delete(id)) {
            out.println("Заявка успешно удалена.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}