import java.util.*;

public class Mathematics {
    public static void main(String[] args) {
        System.out.println("CALCULATOR:");
        String s = new String();
        do {
            Scanner str = new Scanner(System.in);
            s = str.nextLine();
            if (s.equals("exit")) {
                break;
            }
            //
            // Calculator v1 = new Calculator(s);
            // System.out.println(v1.getStrinG() + " = " + v1.getAnsweR());
            Calculator2 v1 = new Calculator2(s);
            System.out.println(v1.getStrinG() + " = " + v1.getAnsweR());
            //
        } while (!s.equals("exit"));
        System.out.println("EXIT");
    }
}
