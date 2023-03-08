package io.ylab.university.lesson1;

import java.util.Scanner;

public class Pell {

  public static void main(String[] args) {

    int n = readNFromConsole();
    long pellValue = getPellValue(n);
    System.out.println(pellValue);
  }

  private static int readNFromConsole() {

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Введите число в диапозоне от 0 до 30 включительно:");
      while (true) {
        if (scanner.hasNextInt()) {
          int n = scanner.nextInt();
          if (n >= 0 && n <= 30) {
            return n;
          }
          else {
            System.out.println("Внимание! Введите число в диапозоне от 0 до 30 включительно:");
          }
        }
        else {
          System.out.println("Ошибка ввода. Введите число:");
          scanner.next();
        }
      }
    }
  }

  public static long getPellValue(int num) {

    if (num == 0) {
      return num;
    }
    else if (num == 1) {
      return num;
    }
    else {
      return (2 * getPellValue(num - 1)) + getPellValue(num - 2);
    }
  }
}
