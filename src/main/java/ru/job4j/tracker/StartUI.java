package ru.job4j.tracker;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id to edit:");
        String name = input.askStr("Enter new name:");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id to delete:");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id===");
        int id = input.askInt("Enter id to find:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка успешно найдена " + item);
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name===");
        String name = input.askStr("Enter name to find:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("Найдены следующие заявки:" + Arrays.toString(items));
        } else {
            System.out.println("Заявки не найдены.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select:");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(input, tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            }  else if (select == 3) {
                deteleItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input imput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(imput, tracker);
    }

}
