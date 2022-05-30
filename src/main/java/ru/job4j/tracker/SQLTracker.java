package ru.job4j.tracker;

import org.postgresql.core.Query;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class SQLTracker implements Store {

    private Connection cn;

    public SQLTracker() {
    }

    public SQLTracker(Connection cn) {
        this.cn = cn;
    }

    @Override
    public void init() {
        try (InputStream in = SQLTracker.class.getClassLoader().getResourceAsStream("app.properties")) {

            Properties config = new Properties();
            config.load(in);

            Class.forName(config.getProperty("driver-class-name"));

            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement("insert into items (name, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet genKeys = statement.getGeneratedKeys()) {
                if (genKeys.next()) {
                    item.setId(genKeys.getInt(1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int rsl = 0;
        try (PreparedStatement statement = cn.prepareStatement("update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            item.setId(id);
            rsl = statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rsl > 0;
    }

    @Override
    public boolean delete(int id) {
        int rsl = 0;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rsl > 0;
    }

    private List<Item> executeStatement(String query) {
        List<Item> items = new LinkedList<>();
        try (Statement statement = cn.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                items.add(new Item(rs.getInt(1),
                        rs.getString(2),
                        rs.getTimestamp(3).toLocalDateTime()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return items;
    }

    @Override
    public List<Item> findAll() {
        return executeStatement("select id, name, created from items");
    }

    @Override
    public List<Item> findByName(String key) {
        return executeStatement(String.format("select id, name, created from items where name = '%s'", key));
    }

    @Override
    public Item findById(int id) {
        return executeStatement(String.format("select id, name, created from items where id = %d", id)).stream().findFirst().orElse(null);
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
