package io.ylab.university.lesson3.task2;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class DatedMapImpl implements DatedMap {

  private HashMap<String, String> map = new HashMap<>();
  private HashMap<String, Date> dateMap = new HashMap<>();

  @Override
  public void put(String key, String value) {

    map.put(key, value);
    dateMap.put(key, new Date());
  }

  @Override
  public String get(String key) {

    return map.get(key);
  }

  @Override
  public boolean containsKey(String key) {

    return map.containsKey(key);
  }

  @Override
  public void remove(String key) {

    map.remove(key);
  }

  @Override
  public Set<String> keySet() {

    return map.keySet();
  }

  @Override
  public Date getKeyLastInsertionDate(String key) {

    return dateMap.getOrDefault(key, null);
  }

}
