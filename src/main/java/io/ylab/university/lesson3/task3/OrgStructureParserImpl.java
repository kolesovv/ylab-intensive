package io.ylab.university.lesson3.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {

  private HashMap<Long, Employee> employeeMap = new HashMap<>();

  @Override
  public Employee parseStructure(File csvFile) throws IOException {

    Employee boss = null;
    try (FileInputStream fis = new FileInputStream(csvFile)) {
      Scanner scanner = new Scanner(fis);
      String currentLine;

      scanner.nextLine();
      while (scanner.hasNextLine()) {
        currentLine = scanner.nextLine();
        Employee currentEmployee = parseLine(currentLine);
        Employee bossOfCurrentEmployee = employeeMap.getOrDefault(currentEmployee.getBossId(), null);
        currentEmployee.setBoss(bossOfCurrentEmployee);
        if (currentEmployee.getBoss() != null) {
          currentEmployee
              .getBoss()
              .getSubordinate()
              .add(currentEmployee);
        }
        employeeMap.put(currentEmployee.getId(), currentEmployee);
        if (currentEmployee.getBossId() == null) {
          boss = currentEmployee;
        }
      }
    }
    return boss;
  }

  private Employee parseLine(String line) {

    String[] employeeDate = line.split(";");
    Employee employee = new Employee();

    String idRow = employeeDate[0];
    if (idRow.matches("\\d")) {
      employee.setId(Long.parseLong(idRow));
    }
    else {
      throw new NumberFormatException();
    }

    String idBossRow = employeeDate[1];
    if (idBossRow.isEmpty()) {
      employee.setBossId(null);
    }
    else if (idBossRow.matches("\\d")) {
      employee.setBossId(Long.parseLong(idBossRow));
    }
    else {
      throw new NumberFormatException();
    }

    employee.setName(employeeDate[2]);
    employee.setPosition(employeeDate[3]);

    return employee;
  }
}
