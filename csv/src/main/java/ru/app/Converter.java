package ru.app;

import java.io.IOException;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.io.*;

public class Converter {

  private final static String baseFile = "user.csv";

  public static void toCSV(User user) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(baseFile), user);
    System.out.println("csv created!");
  }

  public static User toJavaObject() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new File(baseFile), User.class);
  }
}
/*
public class App {
  public static void main(String[] args) {
    System.out.println("\tHELLO!");
    // System.out.println("size = " + args.length);
    if (args.length < 1) {
      System.out.println("Too few arguments");
      return;
    }
    if (!(args[0].contains(".csv"))) {
      System.out.println("Error format");
      return;
    }
    // String line = new String;
    try {
      FileWriter fw = new FileWriter(args[0], false);
      String line = "1;Viktoria;14;08;2001";
      fw.write(line);
      fw.append("\n");
      fw.write("2;Vladimir;31;07;2000\n");

      fw.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    try {
      FileReader fr = new FileReader(args[0]);
      Scanner in = new Scanner(fr);

      while (in.hasNextLine()) {
        String line = in.nextLine();
        System.out.println(line);
        for (String ss : line.split(";")) {
          System.out.println(ss);
        }
      }
      fr.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
*/
