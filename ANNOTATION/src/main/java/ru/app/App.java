package ru.app;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
// import javax.annotation.*;

public class App {
  public static void main(String[] args) {
    try {
      User u1 = new User(1, "Viktoria", "89831208503", "student");
      Class myclass = User.class;
      // получить доступ к методу
      Method toString = u1.getClass().getDeclaredMethod("toString");
      toString.setAccessible(true);
      toString.invoke(u1);

      // toString.invoke(u1, string.class, int.class);
      Method[] array = myclass.getMethods(); // вывести все методы
      for(Method arr : array) {
        System.out.println(arr); // вывести все методы
      }
      System.out.println(u1.getClass().getName()); // вывести все классы
      System.out.println(myclass.getClass().getName()); // вывести все классы

      // как доставать объекты

    //  User u2 = (User)myclass.newInstance().(User)Class.forName("User").getConstructor({String.class, Integer.class}).newInstance("Int", 22); // порадить объект


    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
       e.printStackTrace();
   }
  }
}
/*
public class App {

   public static void main(String[] args) {

      App cls = new App();
      Class c = cls.getClass();

      try {
         // parameter type is null
         Method m = c.getMethod("show", null);
         System.out.println("method = " + m.toString());
      } catch(NoSuchMethodException e) {
         System.out.println(e.toString());
      }

      try {
         // method Long
         Class[] cArg = new Class[1];
         cArg[0] = Long.class;
         Method lMethod = c.getMethod("showLong", cArg);
         System.out.println("method = " + lMethod.toString());
      } catch(NoSuchMethodException e) {
         System.out.println(e.toString());
      }
   }

   public Integer show() {
      return 1;
   }

   public void showLong(Long l) {
      this.l = l;
   }
   long l = 78655;
}
*/
