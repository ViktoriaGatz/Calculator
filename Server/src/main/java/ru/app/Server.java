// main сначала делаем со стороны сервера, а потом со стороны клиента
// начать взаимодействие
// sudo netstat -ntp найти gradle run
package ru.app;

import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8080);
      Socket client = server.accept();
      InputStream inStream = client.getInputStream();
      OutputStream outStream = client.getOutputStream();
      Scanner in = new Scanner(inStream);
      PrintWriter out = new PrintWriter(outStream);
      System.out.println("Hello");
      out.flush();
      client.close();
      server.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
/*
    Олифер "Сетевое взаимодействие"

    server  <- client
            ->
    Три рукопожатия
    Контрольная сумма

    Яндекс Танк

    Потоки, многопоточность
    Работа с интерфейсами
    class MyThread implements Runnable { //thread - поток
        public void run() {
        ...
    }
    public MyThread(Socket client)   //Конструктор
        this
    }

    джексон, обджектМапер Map
    Клиенты с помощью Json

    библиотека Джексон
    Зависимости в gradle, динамическм подтянуть библиотеку
    jackson 2.8.0

    build.gradle

    dependencies {
        comptile ... гит хаб
    }

    Объекты все должны быть list
    socketы сохранять на сервер

    сделать множественную рассылку объектов ?????????
*/
