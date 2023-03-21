package io.ylab.university.lesson3.task1;

public class TransliteratorTest {

  public static void main(String[] args) {

    Transliterator transliterator = new TransliteratorImpl();
    String result = transliterator.transliterate("HELLO! ПРИВЕТ! Go, boy!");
    System.out.println(result);
  }
}
