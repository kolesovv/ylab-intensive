package io.ylab.university.lesson1;

public class MultiTable {

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        sb.append(i)
          .append(" * ")
          .append(j)
          .append(" = ")
          .append(i * j);
        System.out.println(sb);
        sb.setLength(0);
      }
    }
  }
}
