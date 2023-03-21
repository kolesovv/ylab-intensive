package io.ylab.university.lesson3.task4;

public class PasswordValidatorTest {

  public static void main(String[] args) {

    System.out.println(new PasswordValidatorImpl().validate("Abc1_", "Qwe1_", "Qwe1_"));
    System.out.println(new PasswordValidatorImpl().validate("Abc1_", "Qwe_1", "Qwe_1"));
    System.out.println(new PasswordValidatorImpl().validate("Abc1_", "_Qwe1", "_Qwe1"));

    System.out.println(new PasswordValidatorImpl().validate("Abc1", "Asd1_", "Asd1_"));
    System.out.println(new PasswordValidatorImpl().validate("Abc1_", "Asd1", "Asd1"));
    System.out.println(new PasswordValidatorImpl().validate("Abc1_", "Asd1_", "Asd1"));
  }
}
