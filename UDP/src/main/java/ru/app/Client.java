// package ru.app;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.lang.IllegalArgumentException;
import java.net.SocketException;

public class Client {
  public static void main(String[] args) {
    try {
      byte[] data = "Hello".getBytes();
      InetAddress addr = InetAddress.getByName("localhost"); // 192.168.1.3 // может принимать по домену или по ip
      DatagramPacket pack = new DatagramPacket(data, data.length, addr, 19000);
      DatagramSocket ds = new DatagramSocket();
      ds.send(pack);

      DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
      ds.receive(dp); // в случае получения данных будет заполнен dp пакет
      System.out.println(new String(dp.getData())); // можно узнать ещё порт и адрес, чтобы отправить ответ
      System.out.println(dp.getPort());
      System.out.println(dp.getAddress());
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
