import java.util.regex.*;

public class Aa {
    public static void main(String[] args){
        String st = "7+84-44*5-55*4-8";
        String value = "-8";
        Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(st);
        int result = Integer.parseInt(value);
        while (matcher.find(start)) {
            String value = word.substring(matcher.start(), matcher.end());
            result = Integer.parseInt(value);
            // System.out.println(result);
            start = matcher.end();
        }
        System.out.println(result);
    }
}
