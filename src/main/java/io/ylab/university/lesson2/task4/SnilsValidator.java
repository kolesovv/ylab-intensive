package io.ylab.university.lesson2.task4;

public interface SnilsValidator {

  /**
   * Проверяет, что в строке содержится валидный номер СНИЛС
   *
   * @param snils СНИЛС
   * @return результат проверки
   */
  boolean validate(String snils);
}
