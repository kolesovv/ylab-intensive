package io.ylab.university.lesson4.filesort;

import java.io.File;
import javax.sql.DataSource;

public class FileSortImpl implements FileSorter {

  private DataSource dataSource;

  public FileSortImpl(DataSource dataSource) {

    this.dataSource = dataSource;
  }

  @Override
  public File sort(File data) {
    // ТУТ ПИШЕМ РЕАЛИЗАЦИЮ
    return null;
  }
}
