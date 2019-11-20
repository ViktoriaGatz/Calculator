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

      long end = System.nanoTime();
      for (int i = 0; i < 1000; i++) {
        stmt.executeUpdate(
            "INSERT INTO user(id, fio, phone) VALUES (2, \"Viktoria\", \"89831523456\"), (3, \"Alena\", \"89831523456\");");
      }
      end = System.nanoTime() - end;
      System.out.println("1 000 элементов дабавленны в таблицу за " + end +
                         " наносекунд");

      conn.close();
    } catch (java.sql.SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
