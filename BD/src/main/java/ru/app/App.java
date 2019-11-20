package ru.app;

import java.io.IOException;
// import com.mysql.jdbc.Driver;
// import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import java.util.*;

public class App {
  public static void main(String[] args) {
    try {
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/userTables", "root", "");
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(
          "INSERT INTO user(id, fio, phone) VALUES (2, \"Viktoria\", \"89831523456\"), (3, \"Artem\", \"89831523456\");");
      ResultSet rs = stmt.executeQuery("SELECT * FROM user;");
      while (rs.next()) {
        String fio = rs.getString("fio");
        System.out.println(fio);
      }
      conn.close();
    } catch (java.sql.SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
