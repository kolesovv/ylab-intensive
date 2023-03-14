package io.ylab.university.lesson1;

import java.util.Random;
import java.util.Scanner;

public class Guess {

  public static final String FORMAT = "%s %d %s";

  public static void main(String[] args) {

    int number = new Random().nextInt(100);
    int counter = 10;
    int maxAttempts = counter;
    System.out.printf(FORMAT, "Я загадал число от 0 до 99. У тебя есть", counter, "попыток угадать.\n");

    try (Scanner scanner = new Scanner(System.in)) {
      while (counter > 0) {
        int guessAnswer = scanner.nextInt();
        if (guessAnswer == number) {
          System.out.printf(FORMAT, "Ты угадал с", maxAttempts - counter + 1, "попытки!\n");
          break;
        }
        else {
          counter--;
        }

        if (counter == 0) {
          System.out.println("Ты не угадал.");
        }
        else if (guessAnswer > number) {
          System.out.printf(FORMAT, "Мое число меньше! У тебя осталось", counter, "попыток.\n");
        }
        else {
          System.out.printf(FORMAT, "Мое число больше! У тебя осталось", counter, "попыток.\n");
        }
      }
    }
  }
}
