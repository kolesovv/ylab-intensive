package io.ylab.university.lesson3.task4;

public interface PasswordValidator {

  public boolean validate(String login, String password, String confirmPassword);
}
