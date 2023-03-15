package io.ylab.university.lesson2.task3;

import java.time.LocalDateTime;

public class RateLimitedPrinterTest {

  public static void main(String[] args) {

    RateLimitedPrinter printer = new RateLimitedPrinter(2000);

    for (int i = 0; i < 1_000_000_000; i++) {
      printer.print(LocalDateTime.now()
          .withNano(0)
          .toString());
    }
  }
}
