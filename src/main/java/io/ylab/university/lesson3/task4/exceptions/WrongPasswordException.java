package io.ylab.university.lesson3.task4.exceptions;

public class WrongPasswordException extends RuntimeException {

  public WrongPasswordException() {

  }

  public WrongPasswordException(String message) {

    super(message);
  }
}
