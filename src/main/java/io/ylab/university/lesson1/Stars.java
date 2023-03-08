package io.ylab.university.lesson1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Stars {

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      String blank = " ";
      String message = "Введите через пробел количество строк, количество столбцов, произвольный симовол. "
          + "Пример: \"10 10 #\":";
      String errorMessage = "Ошибка ввода данных!";

      while (true) {
        System.out.println(message);
        String input = scanner.nextLine();
        input = input.trim();
        String[] values = input.split(blank);

        if (values.length == 3) {
          if (isPositiveInteger(values[0]) && isPositiveInteger(values[1])) {
            int n = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            String template = values[2];

            printStars(n, m, template);
            return;
          }
          else {
            System.out.println(errorMessage);
          }
        }
        else {
          System.out.println(errorMessage);
        }
      }
    }
  }

  private static void printStars(int n, int m, String template) {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(template);
        // Печатаем пробел, если символ в строке не последний
        if (j < m - 1) {
          System.out.print(" ");
        }
        // Переносим строку, если строка не последняя
        else if (i < n - 1) {
          System.out.println();
        }
      }
    }
  }

  private static boolean isPositiveInteger(String str) {

    Pattern integerPattern = Pattern.compile("\\d+");
    return integerPattern.matcher(str)
        .matches();
  }
}
