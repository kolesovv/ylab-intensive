package io.ylab.university.lesson4.movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;

public class MovieLoaderImpl implements MovieLoader {

  private DataSource dataSource;

  public MovieLoaderImpl(DataSource dataSource) {

    this.dataSource = dataSource;
  }

  @Override
  public void loadData(File file) throws IOException, SQLException {

    ArrayList<Movie> movies = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader reader = new BufferedReader(isr)) {

      reader.readLine();
      reader.readLine();

      reader.lines()
          .forEach(movie -> {
            Movie currentMovie = parseLineToEntity(movie);
            movies.add(currentMovie);
          });
    }

    String insertMovieSQL = "INSERT INTO "
        + "MOVIE(YEAR, LENGTH, TITLE, SUBJECT, ACTORS, ACTRESS, DIRECTOR, POPULARITY, AWARDS) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement movieStatement = connection.prepareStatement(insertMovieSQL)) {

      for (Movie movie : movies) {
        setInt(movieStatement, 1, movie.getYear());
        setInt(movieStatement, 2, movie.getLength());
        setString(movieStatement, 3, movie.getTitle());
        setString(movieStatement, 4, movie.getSubject());
        setString(movieStatement, 5, movie.getActors());
        setString(movieStatement, 6, movie.getActress());
        setString(movieStatement, 7, movie.getDirector());
        setInt(movieStatement, 8, movie.getPopularity());
        setBoolean(movieStatement, 9, movie.getAwards());
        movieStatement.addBatch();
      }
      movieStatement.executeBatch();
    }
  }

  private Movie parseLineToEntity(String line) {

    String[] dataMovie = line.split(";");
    Movie movie = new Movie();

    Integer year = getNumeric(dataMovie[0]);
    Integer length = getNumeric(dataMovie[1]);
    String title = checkStringForNull(dataMovie[2]);
    String subject = checkStringForNull(dataMovie[3]);
    String actors = checkStringForNull(dataMovie[4]);
    String actress = checkStringForNull(dataMovie[5]);
    String director = checkStringForNull(dataMovie[6]);
    Integer popularity = getNumeric(dataMovie[7]);
    String awards = checkStringForNull(dataMovie[8]);

    movie.setYear(year);
    movie.setLength(length);
    movie.setTitle(title);
    movie.setSubject(subject);
    movie.setActors(actors);
    movie.setActress(actress);
    movie.setDirector(director);
    movie.setPopularity(popularity);
    movie.setAwards(Boolean.valueOf(awards));

    return movie;
  }

  private static Integer getNumeric(String str) {

    if (str.equals("")) {
      return null;
    }
    else if (str.matches("[0-9]+")) {
      return Integer.parseInt(str);
    }
    else {
      throw new NumberFormatException(str);
    }
  }

  private static String checkStringForNull(String str) {

    if (str.equals("")) {
      return null;
    }
    else {
      return str;
    }
  }

  private static void setInt(PreparedStatement ps, Integer index, Integer value) throws SQLException {

    if (value == null) {
      ps.setNull(index, Types.NULL);
    }
    else {
      ps.setInt(index, value);
    }
  }

  private static void setString(PreparedStatement ps, Integer index, String value) throws SQLException {

    if (value == null) {
      ps.setNull(index, Types.NULL);
    }
    else {
      ps.setString(index, value);
    }
  }

  private static void setBoolean(PreparedStatement ps, Integer index, Boolean value) throws SQLException {

    if (value == null) {
      ps.setNull(index, Types.NULL);
    }
    else {
      ps.setBoolean(index, value);
    }
  }
}
