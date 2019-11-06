package ru.app;

import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
  public static void main(String[] args) {
    // SS
    try {
      Socket client = new Socket("localhost", 2019);
      Runnable r = new MyThread(client);
      Thread t = new Thread(r);
      t.start();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
