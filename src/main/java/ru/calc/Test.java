import java.math.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String newNumber = "2";
        BigInteger a = new BigInteger(newNumber);
        BigInteger b = BigInteger.valueOf(1000);
        int bb = b.intValue();
        BigInteger first = a.pow(bb);
        System.out.println(first);
    }
}
