package ru.app;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Converter {

  private final static String baseFile = "user.json";

  public static void toJSON(User user) throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    mapper.writeValue(new File(baseFile), user);
    System.out.println("json created!");
  }

  public static User toJavaObject() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new File(baseFile), User.class);
  }
  /*
    public static User toBD() throws IOException {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(new File(baseFile), User.class);
    }
  */
}
