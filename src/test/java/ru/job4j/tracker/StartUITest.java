package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(new String[] {"0", "Item name", "1"});
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {new CreateAction(out), new ExitAction()};
//
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//
//    }

//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Input in = new StubInput(new String[] {"0", "Item name", "1", "1", "Item name2", "2"});
//        UserAction[] actions = {new CreateAction(out), new EditAction(out), new ExitAction()};
//
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name2"));
//
//
//    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:0. Exit program"));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"3", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:0. Exit program"
                + "Некорректный пункт меню"
                + "Menu:0. Exit program"));
    }

}