import java.util.regex.*;

public class Aa {
    public static void main(String[] args){
        String st = "7+84-44*5-55*4-8";
        int first = 44;
        int second = 5;
        int answer = 220;
        st = st.replaceFirst(Integer.toString(first)+"\\*"+Integer.toString(second), Integer.toString(answer));
        System.out.println(st);
    }
}
