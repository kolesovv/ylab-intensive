package io.ylab.university.lesson2.task2;

public class ComplexNumber {

  private double realNumber;
  private double imaginaryNumber;

  public ComplexNumber(double realNumber) {

    this(realNumber, 0);
  }

  public ComplexNumber(double realNumber, double imaginaryNumber) {

    this.realNumber = realNumber;
    this.imaginaryNumber = imaginaryNumber;
  }

  /**
   * Добавляет <code>ComplexNumber</code> к текущему комплексному числу
   *
   * @param z комплексное число, которое будет добавлено к текущему комплексному числу
   * @return <code>ComplexNumber</code>
   */
  public ComplexNumber add(ComplexNumber z) {

    return new ComplexNumber(this.realNumber + z.realNumber,
        this.imaginaryNumber + z.imaginaryNumber);
  }

  /**
   * Вычитает <code>ComplexNumber</code> из текущего комплексного числа
   *
   * @param z комплексное число, которое будет вычтено из текущего комплексного числа
   * @return <code>ComplexNumber</code>
   */
  public ComplexNumber subtract(ComplexNumber z) {

    return new ComplexNumber(this.realNumber - z.realNumber,
        this.imaginaryNumber - z.imaginaryNumber);
  }

  /**
   * Умножает <code>ComplexNumber</code> на текущее комплексное число
   *
   * @param z комплексное число, которе будет умножено на текущее комплексное число
   * @return <code>ComplexNumber</code>
   */
  public ComplexNumber multiply(ComplexNumber z) {

    double realNumber = this.realNumber * z.realNumber - this.imaginaryNumber * z.imaginaryNumber;
    double imaginaryNumber = this.realNumber * z.imaginaryNumber + this.imaginaryNumber * z.realNumber;
    return new ComplexNumber(realNumber, imaginaryNumber);
  }

  /**
   * Модуль текущего комплексного числа
   *
   * @return модуль текущего комплексного числа
   */
  public double mod() {

    return Math.sqrt(Math.pow(this.realNumber, 2) + Math.pow(this.imaginaryNumber, 2));
  }

  @Override
  public String toString() {

    if (realNumber == 0) {
      return String.format("%.2fi", imaginaryNumber);
    }
    else if (imaginaryNumber == 0) {
      return String.format("%.2f", realNumber);
    }
    else {
      return String.format("%.2f + %.2fi", realNumber, imaginaryNumber);
    }
  }
}
