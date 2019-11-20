import java.util.*;
import static java.util.stream.Collectors.*;

public class Main {

  public static void main(java.lang.String[] args) {
    long run = System.nanoTime();
    long end = System.nanoTime();
    /*----------------------------------------------------------------------------*/
    run = System.nanoTime();

    ArrayList<Integer> list = new ArrayList<>(1000);

    end = System.nanoTime() - run;
    System.out.println("Коллекция создавалась " + end + " наносекунд");
    /*----------------------------------------------------------------------------*/

    run = System.nanoTime();

    for (int i = 1; i <= 1000; i++) {
      list.add(i);
    }

    end = System.nanoTime() - run;
    System.out.println("Коллекция заполнялась " + end + " наносекунд");
    /*----------------------------------------------------------------------------*/
    List<Integer> list1 = list.stream()
                              .filter(x -> {
                                int temp;
                                boolean isPrime = true;
                                for (int i = 2; i <= x / 2; i++) {
                                  temp = x % i;
                                  if (temp == 0) {
                                    isPrime = false;
                                    break;
                                  }
                                }
                                return isPrime;
                              })
                              .map(x -> x * x)
                              .collect(toList());

    System.out.println(list);
    System.out.println(list1);
    /*
        System.out.println("Коллекция:");
        System.out.println("Перемешаем:");
        Collections.shuffle(list); //перемешиваем
        System.out.println(list);
    */
  }
}
