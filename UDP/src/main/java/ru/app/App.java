package ru.app;

public class App {
  public void main(String[] args) {
      ExecutorService service = new ExecutorService();
      Executors.newFixedThreadPool(50);
      service.submit((socked) -> {System.out.println("HELLO")})
      *Лямбда выражение, threadObj, new Runnable{void run(){…}}

  }
}
// На тысячу клиентов создаётся 1000 потоков, легковесные освобождаются через ~5 минут бездействия
public class App {
  public void main(String[] args) {
      ExecutorService service = new ExecutorService();
      Executors.newCachedThreadPool();
      service.submit((socked) -> {System.out.println("HELLO")})
  }
}
// Всё делается через один поток
public class App {
  public void main(String[] args) {
      ExecutorService service = new ExecutorService();
      Executors.newSingleThreadExecutor();
      service.submit((socked) -> {System.out.println("HELLO")})
  }
}

public class App {
  public void main(String[] args) {
      ExecutorService service = new ExecutorService();
      Executors.newSheduledThreadPool(10);
      service.shedule(thread, 5, TimeUnit.SECONDS);
      service.submit((socked) -> {System.out.println("HELLO")})
  }
}

4) Executors.newSheduledThreadPool(10);
service.shedule(thread, 5, TimeUnit.SECONDS);

UDP C<->S send "hi", get "HI"
Executors with Executors Client многопоточный убиватор, поражение потоков
