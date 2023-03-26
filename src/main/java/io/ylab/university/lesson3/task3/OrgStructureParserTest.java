package io.ylab.university.lesson3.task3;

import java.io.IOException;
import java.nio.file.Paths;

public class OrgStructureParserTest {

  public static void main(String[] args) throws IOException {

    OrgStructureParser osp = new OrgStructureParserImpl();
    Employee boss = osp.parseStructure(Paths.get("src/main/java/io/ylab/university/lesson3/task3/data.csv")
        .toFile());

    System.out.println(boss);
    System.out.println(boss.getSubordinate()
        .get(0));
    System.out.println(boss.getSubordinate()
        .get(0)
        .getSubordinate());
  }
}
