package io.ylab.university.lesson2.task1;

public class SequenceGeneratorImpl implements SequenceGenerator {

  @Override
  public void a(int n) {

    System.out.print("A. ");
    int evenNumber = 2;
    int increment = 2;
    printSequenceOfNaturalNumbersWithIncrement(n, evenNumber, increment);
  }

  @Override
  public void b(int n) {

    System.out.print("B. ");
    int oddNumber = 1;
    int increment = 2;
    printSequenceOfNaturalNumbersWithIncrement(n, oddNumber, increment);
  }

  @Override
  public void c(int n) {

    System.out.print("C. ");
    int power = 2;
    printSequenceOfNaturalNumbersRaisedToPower(n, power);
  }

  @Override
  public void d(int n) {

    System.out.print("D. ");
    int power = 3;
    printSequenceOfNaturalNumbersRaisedToPower(n, power);
  }

  @Override
  public void e(int n) {

    System.out.print("E. ");
    int number = -1;
    for (int i = 0; i < n; i++) {
      number = getOppositeNumber(number);
      print(number);
    }
    System.out.println();
  }

  @Override
  public void f(int n) {

    System.out.print("F. ");
    for (int i = 1; i < n + 1; i++) {
      if (i % 2 == 0) {
        int number = getOppositeNumber(i);
        print(number);
      }
      else {
        print(i);
      }
    }
    System.out.println();
  }

  @Override
  public void g(int n) {

    System.out.print("G. ");
    int power = 2;
    for (int i = 1; i < n + 1; i++) {
      int number = (int) Math.pow(i, power);
      if (i % 2 == 0) {
        number = getOppositeNumber(number);
        print(number);
      }
      else {
        print(number);
      }
    }
    System.out.println();
  }

  @Override
  public void h(int n) {

    System.out.print("H. ");
    int number = 1;
    int count = 0;
    while (count < n) {
      print(number++);
      count++;
      if (count < n) {
        print(0);
        count++;
      }
    }
    System.out.println();
  }

  @Override
  public void i(int n) {

    System.out.print("I. ");
    for (int i = 1; i < n + 1; i++) {
      System.out.printf("%d ", getFactorial(i));
    }
    System.out.println();
  }

  private static long getFactorial(int num) {

    if (num >= 1) {
      return num * getFactorial(num - 1);
    }
    else {
      return 1;
    }
  }

  @Override
  public void j(int n) {

    System.out.print("J. ");
    for (int i = 1; i < n + 1; i++) {
      System.out.printf("%d ", getFibonacci(i));
    }
    System.out.println();
  }

  private static long getFibonacci(int num) {

    if (num == 0) {
      return num;
    }
    else if (num == 1) {
      return num;
    }
    else {
      return getFibonacci(num - 1) + getFibonacci(num - 2);
    }
  }

  private static void print(int number) {

    System.out.printf("%d ", number);
  }

  private static void printSequenceOfNaturalNumbersWithIncrement(int count, int iterableNumber, int increment) {

    for (int i = 0; i < count; i++) {
      print(iterableNumber);
      iterableNumber += increment;
    }
    System.out.println();
  }

  private static void printSequenceOfNaturalNumbersRaisedToPower(int count, int power) {

    for (int i = 1; i < count + 1; i++) {
      print((int) Math.pow(i, power));
    }
    System.out.println();
  }

  private static int getOppositeNumber(int number) {

    number *= -1;
    return number;
  }
}
