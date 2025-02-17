package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select:");
            if (select < 0 || select >= actions.size()) {
                out.println("Некорректный пункт меню");
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {

        out.println("Menu:");
        int i = 0;
        for (UserAction action : actions) {
            out.println(i++ + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        SQLTracker tracker = new SQLTracker();
        tracker.init();
        List<UserAction> actions = List.of(new CreateAction(output), new ShowAllAction(output), new EditAction(output),
        new DeleteAction(output), new FindItemByIdAction(output), new FindItemByNameAction(output), new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }

}
