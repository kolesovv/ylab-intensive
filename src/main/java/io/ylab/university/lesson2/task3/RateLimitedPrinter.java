package io.ylab.university.lesson2.task3;

public class RateLimitedPrinter {

  private int interval;
  private long latestPrintTime;

  public RateLimitedPrinter(int interval) {

    this.interval = interval;
  }

  public void print(String input) {

    long currentTime = System.currentTimeMillis();
    if ((currentTime - latestPrintTime) > interval) {
      System.out.println(input);
      this.latestPrintTime = currentTime;
    }
  }
}
