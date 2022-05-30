package ru.job4j.tracker.store;

import ru.job4j.tracker.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {
    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));

            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeClass() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SQLTracker tracker = new SQLTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SQLTracker tracker = new SQLTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()).get(0), is(item));
    }

    @Test
    public void whenSave2ItemsAndFindAll() {
        SQLTracker tracker = new SQLTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item1");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> expected = List.of(item1, item2);

        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenSave2ItemsAndDelete1() {
        SQLTracker tracker = new SQLTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        List<Item> expected = List.of(item2);

        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenSave2ItemsAndReplace() {
        SQLTracker tracker = new SQLTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.replace(item1.getId(), item3);
        List<Item> expected = List.of(item3, item2);

        assertThat(tracker.findAll(), is(expected));
    }
}
