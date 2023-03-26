package io.ylab.university.lesson3.task5;

import java.io.File;

public class FileSortTest {

  public static void main(String[] args) throws Exception {

    File dataFile = new Generator().generate("data.txt", 1500);
    System.out.println(new Validator(dataFile).isSorted()); // false
    File sortedFile = new Sorter().sortFile(dataFile);
    System.out.println(new Validator(sortedFile).isSorted()); // true
  }
}
