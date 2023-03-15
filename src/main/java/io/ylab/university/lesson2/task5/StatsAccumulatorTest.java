package io.ylab.university.lesson2.task5;

import java.util.Arrays;
import java.util.List;

public class StatsAccumulatorTest {

  public static void main(String[] args) {

    List<Integer> listOfIntegers = Arrays.asList(11, 13, 9, 20, 7, 3, 30);
    StatsAccumulator statsAccumulator = new StatsAccumulatorImpl();

    print(statsAccumulator);
    for (int i : listOfIntegers) {
      statsAccumulator.add(i);
      print(statsAccumulator);
    }
  }

  private static void print(StatsAccumulator statsAccumulator) {

    String pattern = "%s: %d%n";
    System.out.printf(pattern, "Min", statsAccumulator.getMin());
    System.out.printf(pattern, "Max", statsAccumulator.getMax());
    System.out.printf(pattern, "Count", statsAccumulator.getCount());
    System.out.printf("%s: %.2f%n", "Average", statsAccumulator.getAvg());
    System.out.println("-----");
  }
}
