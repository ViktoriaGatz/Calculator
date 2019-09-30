import java.util.regex.*;
import java.util.*;

public class Test {
    public static void main(String[] args){
        String str = "7+84-44*5-50*4-8";
        String st = new String(str);
        int first = -1234567890;
        int second = -1234567890;
        int buff = -1234567890;
        int answer = -1234567890;
        Queue<String> queue = new LinkedList<String>(); // Очередь из элементов, между которыми стоит знак
        for (String ss : str.split("\\*")) {
            queue.offer(ss);
        }
        /*
        while (queue.peek() != null) {
            System.out.println(queue.peek().toString());
            queue.poll();
        }
        */
        while (queue.peek() != null) {
            System.out.println(queue.peek().toString());
            second = Pattern4(queue.peek().toString());
            queue.poll();
            while (queue.peek() != null) {
                first = Pattern5(queue.peek().toString());
                // Умножение
                answer = first * second;
                // System.out.println("ANSWER = "Integer.toString(answer));
                // Замена
                st = st.replaceFirst(Integer.toString(second)+"\\*"+Integer.toString(first), Integer.toString(answer));
                System.out.println("STR = " + st);
                second = Pattern4(queue.peek().toString());
                queue.poll();
            }
        }
    }

    static int Pattern4(String word) { // Должно вернуть последнее число в строке
        Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(word);
        int start = 0;
        int result = -1234567890;
        while (matcher.find(start)) {
            String value = word.substring(matcher.start(), matcher.end());
            result = Integer.parseInt(value);
            // System.out.println(result);
            start = matcher.end();
        }
        if (result == -1234567890) {
            System.out.println("ERROR BEFORE '*'");
            System.exit(0);
        }
        return result;
    }

    static int Pattern5(String word) { // Должно вернуть первое число в строке
        Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(word);
        int start = 0;
        int result = -1234567890;
        if (matcher.find(start)) {
            String value = word.substring(matcher.start(), matcher.end());
            result = Integer.parseInt(value);
            // System.out.println(result);
            start = matcher.end();
        }
        if (result == -1234567890) {
            System.out.println("ERROR AFTER '*'");
            return -1;
        }
        return result;
    }
}
