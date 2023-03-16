package io.ylab.university.lesson2.task5;

public class StatsAccumulatorImpl implements StatsAccumulator {

  private int count;
  private int min;
  private int max;
  private long sum;

  @Override
  public void add(int value) {

    count++;
    if (count == 1) {
      min = value;
      max = value;
    }
    else if (value < min) {
      min = value;
    }
    else {
      max = value;
    }
    sum += value;
  }

  @Override
  public int getMin() {

    return min;
  }

  @Override
  public int getMax() {

    return max;
  }

  @Override
  public int getCount() {

    return count;
  }

  @Override
  public double getAvg() {

    double result = 0;
    if (count != 0) {
      result = (double) sum / getCount();
    }
    return result;
  }
}
