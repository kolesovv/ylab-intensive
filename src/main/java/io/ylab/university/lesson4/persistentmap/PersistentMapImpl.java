package io.ylab.university.lesson4.persistentmap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 * Класс, методы которого надо реализовать
 */
public class PersistentMapImpl implements PersistentMap {

  private String currentMap;

  private DataSource dataSource;

  public PersistentMapImpl(DataSource dataSource) {

    this.dataSource = dataSource;
  }

  @Override
  public void init(String name) {

    currentMap = name;
  }

  @Override
  public boolean containsKey(String key) throws SQLException {

    return get(key) != null;
  }

  @Override
  public List<String> getKeys() throws SQLException {

    String getKeysSQL = "select key from persistent_map where map_name = ?";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(getKeysSQL);) {
      statement.setString(1, currentMap);
      ResultSet rs = statement.executeQuery();
      List<String> keys = new ArrayList<>();
      while (rs.next()) {
        keys.add(rs.getString("key"));
      }
      return keys;
    }
  }

  @Override
  public String get(String key) throws SQLException {

    String getSQL = "select value from persistent_map where map_name = ? and key = ?";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(getSQL)) {
      statement.setString(1, currentMap);
      statement.setString(2, key);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        return rs.getString("value");
      }
      else {
        return null;
      }
    }
  }

  @Override
  public void remove(String key) throws SQLException {

    String removeSQl = "delete from persistent_map where map_name = ? and key = ?";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(removeSQl)) {
      statement.setString(1, currentMap);
      statement.setString(2, key);
      statement.execute();
    }
  }

  @Override
  public void put(String key, String value) throws SQLException {

    remove(key);
    String putSQL = "insert into persistent_map(map_name, key, value) values (?, ?, ?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(putSQL)) {
      statement.setString(1, currentMap);
      statement.setString(2, key);
      statement.setString(3, value);
      statement.execute();
    }
  }

  @Override
  public void clear() throws SQLException {

    String clearSQl = "delete from persistent_map where map_name = ?";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(clearSQl)) {
      statement.setString(1, currentMap);
      statement.execute();
    }
  }
}
