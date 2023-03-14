package io.ylab.university.lesson2.task2;

public class ComplexNumberTest {

  public static void main(String[] args) {

    ComplexNumber z = new ComplexNumber(76.8, 24.0);
    ComplexNumber another = new ComplexNumber(8.67);

    System.out.println("Complex number: " + z);
    System.out.println("Another complex number: " + another);
    System.out.println();

    System.out.println("Sum: " + z.add(another));
    System.out.println("Subtraction: " + z.subtract(another));
    System.out.println("Multiplication: " + z.multiply(another));
    System.out.printf("%s: %.1f", "Module", z.mod());
  }
}
