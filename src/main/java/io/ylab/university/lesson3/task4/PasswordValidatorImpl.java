package io.ylab.university.lesson3.task4;

import io.ylab.university.lesson3.task4.exceptions.WrongLoginException;
import io.ylab.university.lesson3.task4.exceptions.WrongPasswordException;

public class PasswordValidatorImpl implements PasswordValidator {

  private final String passwordsDontMatch = "Пароль и подтверждение не совпадают!";
  private final String loginIsToLong = "Логин слишком длинный!";
  private final String passwordIsToLong = "Пароль слишком длинный!";
  private final String loginContainsInvalidCharacters = "Логин содержит недопустимые символы!";
  private final String passwordContainsInvalidCharacters = "Пароль содержит недопустимые символы!";
  private final String pattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*_)\\w+";

  @Override
  public boolean validate(String login, String password, String confirmPassword) {

    try {
      if (!password.equals(confirmPassword)) {
        throw new WrongPasswordException(passwordsDontMatch);
      }
      else {
        return validateLogin(login) && validatePassword(password);
      }
    }
    catch (WrongPasswordException | WrongLoginException ex) {
      ex.printStackTrace();
      return false;
    }
  }

  private boolean validateLogin(String login) {

    try {
      if (login.length() > 20) {
        throw new WrongLoginException(loginIsToLong);
      }
      else if (!login.matches(pattern)) {
        throw new WrongLoginException(loginContainsInvalidCharacters);
      }
    }
    catch (WrongLoginException ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }

  private boolean validatePassword(String password) {

    try {
      if (password.length() > 20) {
        throw new WrongPasswordException(passwordIsToLong);
      }
      else if (!password.matches(pattern)) {
        throw new WrongPasswordException(passwordContainsInvalidCharacters);
      }
    }
    catch (WrongPasswordException ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }
}
