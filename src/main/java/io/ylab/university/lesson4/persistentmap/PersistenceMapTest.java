package io.ylab.university.lesson4.persistentmap;

import io.ylab.university.lesson4.DbUtil;
import java.sql.SQLException;
import javax.sql.DataSource;

public class PersistenceMapTest {

  public static void main(String[] args) throws SQLException {

    DataSource dataSource = initDb();
    PersistentMap persistentMap = new PersistentMapImpl(dataSource);
    // Написать код демонстрации работы
    // Инициализация первой мапы и добавление в мапу
    persistentMap.init("Map1");
    persistentMap.put("1", "One");
    persistentMap.put("2", "Two");
    persistentMap.put("3", "Three");

    // Инициализация второй мапы и добавление в мапу
    persistentMap.init("Map2");
    persistentMap.put("1", "Uno");
    persistentMap.put("2", "Due");
    persistentMap.put("3", "Tre");

    // Инициализация первой мапы и добавление в мапу значение с существующем ключом
    persistentMap.init("Map1");
    persistentMap.put("3", "Три");
    persistentMap.put("3", "Tri");

    System.out.println("Ключи Map1: " + persistentMap.getKeys());
    System.out.println("Значение в Map1 под ключом 3: " + persistentMap.get("3"));

    // Удаление значения с ключом 3
    System.out.println("Удаление значения с ключом 3 ...");
    persistentMap.remove("3");
    System.out.println("Значения в Map1: " + persistentMap.getKeys());

    // Вывод проверки существования значения под ключом 3
    System.out.println("Вывод проверки существования значения под ключом 3: " + persistentMap.containsKey("3"));

    // Очистка мапы Map1
    System.out.println("Очистка мапы Map1 ...");
    persistentMap.clear();
    System.out.println("Значения в Map1: " + persistentMap.getKeys());

    // Инициализация второй мапы
    System.out.println("Инициализация второй мапы ...");
    persistentMap.init("Map2");
    System.out.println("Значения в Map2: " + persistentMap.getKeys());
  }

  public static DataSource initDb() throws SQLException {

    String createMapTable = ""
        + "drop table if exists persistent_map; "
        + "CREATE TABLE if not exists persistent_map (\n"
        + "   map_name varchar,\n"
        + "   KEY varchar,\n"
        + "   value varchar\n"
        + ");";
    DataSource dataSource = DbUtil.buildDataSource();
    DbUtil.applyDdl(createMapTable, dataSource);
    return dataSource;
  }
}
