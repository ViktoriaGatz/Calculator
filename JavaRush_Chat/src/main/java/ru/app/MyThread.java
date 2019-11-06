package ru.app;

import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread implements Runnable {
  public void run() { System.out.println("I’m printer"); }

  public MyThread(Socket client) { /*this ...*/
  }
}
