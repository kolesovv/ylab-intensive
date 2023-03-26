package io.ylab.university.lesson3.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sorter {

  public File sortFile(File dataFile) throws IOException {

    int numberOfPartitions = 5;
    String tempFolder = "./temp/";
    File resultFile = new File("result.txt");

    int countLines = getCountLines(dataFile);
    int sizeOfPortion = countLines / numberOfPartitions;
    int remainingLines = countLines % numberOfPartitions;

    File dir = new File(tempFolder);
    if (dir.exists()) {
      dir.delete();
    }
    dir.mkdir();

    System.out.println("Количество строк: " + countLines);

    try (InputStream fis = new FileInputStream(dataFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(isr)) {

      long start = System.currentTimeMillis();
      List<File> files = new ArrayList<>();

      for (int i = 0; i < numberOfPartitions; i++) {
        if (i == numberOfPartitions - 1 && remainingLines != 0) {
          sizeOfPortion += remainingLines;
        }
        File file = new File(tempFolder + "portion-" + i + ".txt");
        files.add(file);
        try (OutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw)) {
          long[] data = new long[sizeOfPortion];
          int currentSize = 0;
          while (currentSize < sizeOfPortion) {
            data[currentSize] = Long.parseLong(reader.readLine());
            currentSize++;
          }
          mergeSort(data);

          for (long l : data) {
            writer.write(l + "\n");
          }
        }
      }

      mergeSortedFiles(files, resultFile);

      long finish = System.currentTimeMillis() - start;
      System.out.printf("Продолжительность: %.2f сек.\n", (double) finish / 1000);
    }
    catch (NullPointerException | IOException ex) {
      ex.printStackTrace();
    }

    return resultFile;
  }

  private int getCountLines(File file) throws IOException {

    int lines = 0;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      while (reader.readLine() != null) {
        lines++;
      }
      return lines;
    }
  }

  private void mergeSortedFiles(List<File> files, File output) throws IOException {

    List<BufferedReader> readers = new ArrayList<>();
    TreeMap<String, BufferedReader> map = new TreeMap<>((s1, s2) -> {
      long l1 = Long.parseLong(s1);
      long l2 = Long.parseLong(s2);
      return Long.compare(l1, l2);
    });

    if (output.exists()) {
      output.delete();
    }
    try (OutputStream fos = new FileOutputStream(output, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter writer = new BufferedWriter(osw)) {

      for (File file : files) {
        BufferedReader br = new BufferedReader(new FileReader(file));
        map.put(br.readLine(), br);
        readers.add(br);
      }
      while (!map.isEmpty()) {
        Map.Entry<String, BufferedReader> next = map.pollFirstEntry();
        writer.write(next.getKey() + "\n");

        String line = next.getValue().readLine();
        if (line != null) {
          map.put(line, next.getValue());
        }
      }
    }
    catch (NullPointerException | IOException ex) {
      ex.printStackTrace();
    }
    finally {
      for (BufferedReader reader : readers) {
        reader.close();
      }
      for (File file : files) {
        file.delete();
      }
      File directory = files.get(0).getParentFile();
      if (directory.exists()) {
        directory.delete();
      }
    }
  }

  private void mergeSort(long[] array) {

    int n = array.length;
    if (n < 2) {
      return;
    }
    int middle = n / 2;
    long[] leftArray = new long[middle];
    long[] rightArray = new long[n - middle];

    for (int i = 0; i < middle; i++) {
      leftArray[i] = array[i];
    }
    for (int i = middle; i < n; i++) {
      rightArray[i - middle] = array[i];
    }
    mergeSort(leftArray);
    mergeSort(rightArray);

    merge(array, leftArray, rightArray);
  }

  private void merge(long[] array, long[] left, long[] right) {

    int leftPos = 0;
    int rightPos = 0;
    for (int i = 0; i < array.length; i++) {
      if (leftPos > left.length - 1) {
        array[i] = right[rightPos];
        rightPos++;
      }
      else if (rightPos > right.length - 1) {
        array[i] = left[leftPos];
        leftPos++;
      }
      else if (left[leftPos] < right[rightPos]) {
        array[i] = left[leftPos];
        leftPos++;
      }
      else {
        array[i] = right[rightPos];
        rightPos++;
      }
    }
  }
}
