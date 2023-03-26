package io.ylab.university.lesson3.task2;

public class DatedMapTest {

  public static void main(String[] args) throws InterruptedException {

    DatedMap datedMap = new DatedMapImpl();

    datedMap.put("key1", "value1");
    datedMap.put("key2", "value2");
    datedMap.put("key3", "value3");
    datedMap.put("key4", "value4");
    datedMap.put("key5", "value5");

    System.out.println("Value of existing key1 : " + datedMap.get("key1"));

    System.out.println("Is contain key2? : " + datedMap.containsKey("key2"));

    System.out.println("Remove key3");
    datedMap.remove("key3");
    System.out.println("Is contain key3? : " + datedMap.containsKey("key3"));

    System.out.println("Set of keys :" + datedMap.keySet());

    System.out.println("Get latest insert date for a non-existent key: " + datedMap.getKeyLastInsertionDate("key0"));
    System.out.println("Get latest insert date for a existing key4: " + datedMap.getKeyLastInsertionDate("key4"));
    System.out.println("Sleep for 10 seconds and update value with key4 ...");
    Thread.sleep(10_000);
    datedMap.put("key4", "valueFour");
    System.out.println("Get latest insert date for existing key4 again: " + datedMap.getKeyLastInsertionDate("key4"));
  }
}
