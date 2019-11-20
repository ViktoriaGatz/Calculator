// Создать лист из объектов и отправить его в файл
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
      /*
      stmt.executeUpdate(
          "INSERT INTO user(id, fio, phone) VALUES (2, \"Viktoria\",
      \"89831523456\"), (3, \"Artem\", \"89831523456\");");
    */
      ResultSet rs = stmt.executeQuery("SELECT * FROM user;");
      while (rs.next()) {
        int id = rs.getInt("id");
        String fio = rs.getString("fio");
        String phone = rs.getString("phone");

        User user = new User(id, fio, phone, "student");
        System.out.println(user.toString());
        Converter converter = new Converter();

        try {
          converter.toJSON(user);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
      conn.close();
    } catch (java.sql.SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
/*
package ru.app;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        // objectmapper mapper = new objectmapper();
        // В json
        // String str = mapper.writeValutAsString(user1);
        // Обратно
        // List<User>user2 = mapper.readValue(str, User.class);

        User user1 = new User(1, "Viki", "89831208504", "student");
        System.out.println(user1.toString());

        User user2 = new User(2, "Vova", "89831209888", "student");
        System.out.println(user2.toString());

        User user3 = new User(3, "Lilit", "89832999980", "student");
        System.out.println(user3.toString());

        User user = new User(1, "Kira", "89839581938", "student");
        System.out.println(user.toString());

        Converter converter = new Converter();
        try {
            converter.toJSON(user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user1 = converter.toJavaObject();
            System.out.println(user1.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
*/
