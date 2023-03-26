package io.ylab.university.lesson3.task4.exceptions;

public class WrongLoginException extends RuntimeException {

  public WrongLoginException() {

  }

  public WrongLoginException(String message) {

    super(message);
  }
}
