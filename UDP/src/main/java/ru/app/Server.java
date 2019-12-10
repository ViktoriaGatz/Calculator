// package ru.app;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.io.IOException;
import java.net.InetAddress;

public class Server {
  public static void main(String[] args) {
    try {
      DatagramSocket ds = new DatagramSocket(19000);

      while(true){
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        
        ds.receive(dp); // в случае получения данных будет заполнен dp пакет
        System.out.println(new String(dp.getData())); // можно узнать ещё порт и адрес, чтобы отправить ответ
        System.out.println(dp.getPort());
        System.out.println(dp.getAddress());
        // String str = dp.getData().toString();
        // str.toUpperCase();
        byte[] data = new String(dp.getData()).toUpperCase().getBytes();
        DatagramPacket pack = new DatagramPacket(data, data.length, dp.getAddress(), dp.getPort());
        ds.send(pack);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
