/*
    КАЛЬКУЛЯТОР

    Классы-оболочки:

    Byte
    Short
    Integer
    Long
    Float
    Double
    Character
    Boolean


import java.util.Scanner;
*/
package ru.calc;

import java.math.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    private String strinG;
    private int answeR = 0;

    Calculator() {
        this.setStrinG("0");
    }

    Calculator(String c) {
        this.setStrinG(c);
    }
    public String getStrinG() {
        return strinG;
    }

    public void setStrinG(String c) {
        this.strinG = new String(c);
    }

    public int getAnsweR() {
        String s = new String(strinG);
        s = s.replaceAll(" ", "");
        if (MyDelete(s)) {
            System.out.print("Error symbol\t");
            return answeR;
        } else {
        Stack<String> stack = Expression(s);
        answeR = Rachet(stack);
        // System.out.println(s + " = " + answer);
        }
        return answeR;
    }
/*
    public void setStrinG(String c) {
        this.strinG = new String(c);
    }
*/
    public static Stack<String> Expression(String str) {
        Stack<String> stack = new Stack<>();
        for (String ss : str.split("\\(")) {
            stack.push(ss);
        }
        return stack;
    }

    public boolean MyDelete(String str) {
        String s = new String(str);
        s = s.replaceAll("\\d|\\+|\\*|/|\\^|-|\\(|\\)|\\s|\\.", "");
        if (s.length() == 0)
            return false;
        else
            return true;
    }

    public static Integer Rachet(Stack<String> stack) {
        // System.out.println(stack);
        // System.out.println(stack.peek().toString());
        String st = new String(stack.peek().toString());
        int n = stack.size();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String ss = new String(stack.peek().toString());
            String s = Pattern1(ss, ".+?\\)"); // Из последнего элемента стека берём только часть до первой ")"
            answer = Pattern2(s);
            // System.out.println(answer);
            st = ss.replaceFirst(stack.peek().toString(), Integer.toString(answer));
        }
        return answer;
    }

    public static Integer Pattern2(String str) {
        String ss = new String(str);
        ss = ss.replaceAll("\\)", ""); // Убираем последнюю скобочку, получаем "чистое" выражение: 733+80*95
        ss =  Pattern3(ss, "\\^");
        ss =  Pattern3(ss, "\\^");
        ss =  Pattern3(ss, "\\*"); // Получаем
        ss =  Pattern3(ss, "\\*"); // Получаем
        ss =  Pattern3(ss, "/");
        ss =  Pattern3(ss, "/");
        ss =  Pattern3(ss, "-");
        ss =  Pattern3(ss, "-");
        ss =  Pattern3(ss, "\\+");
        ss =  Pattern3(ss, "\\+");
        int answer = Integer.parseInt(ss);
        return answer;
    }

    public static String Pattern3(String str, String c) { // String // Выполнение действий (первое - умножение)
        String st = new String(str);
        if (contains("(.*)" + c + "(.*)", str)) { // Если строка содержит знак
            int first = -1234567890;
            int second = -1234567890;
            int buff = -1234567890;
            int answer = -1234567890;
            Queue<String> queue = new LinkedList<String>(); // Очередь из элементов, между которыми стоит знак
            for (String ss : str.split(c)) {
                queue.offer(ss);
            }
            while (queue.peek() != null) {
                // System.out.println(queue.peek().toString());
                second = Pattern4(queue.peek().toString());
                queue.poll();
                while (queue.peek() != null) {
                    first = Pattern5(queue.peek().toString());
                    // Умножение
                    switch (c) {
                        case "\\*":
                            answer = first * second;
                            break;
                        case "\\+":
                            answer = first + second;
                            break;
                        case "-":
                            answer = second - first;
                            break;
                        case "/":
                            answer = second / first;
                            break;
                        case "\\^":
                            BigInteger a = BigInteger.valueOf(second);
                            BigInteger b = BigInteger.valueOf(first);
                            int bb = b.intValue();
                            BigInteger answer1 = a.pow(bb);
                            System.out.println("ANSWER1 = " + answer1);
                            answer = answer1.intValue();
                            System.out.println("ANSWER = " + answer);
                            break;
                        default:
                            break;
                    }
                    // System.out.println(Integer.toString(answer));
                    // Замена
                    st = st.replaceFirst(Integer.toString(second)+c+Integer.toString(first), Integer.toString(answer));
                    // System.out.println("STR = " + st);
                    second = Pattern4(queue.peek().toString());
                    queue.poll();
                }
            }
        }
        return st;
    }

    public static boolean contains(String pattern, String content) { // contains("(.*)&&(.*)", "REMBO IUI Z&&")
        return content.matches(pattern);
    }

    public static String Pattern1(String str, String s) { // String s = Pattern1(ss, ".+?\\)");
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return(str.substring(matcher.start(), matcher.end()));
        }
        return str;
    }

    public static int Pattern4(String word) { // Должно вернуть последнее число в строке
        Pattern pattern = Pattern.compile("\\d+"); // "[-]?[0-9]+(.[0-9]+)?"
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
            // System.out.println("ERROR BEFORE SYMBOL");
            // System.exit(0);
        }
        return result;
    }

    public static int Pattern5(String word) { // Должно вернуть первое число в строке
        Pattern pattern = Pattern.compile("\\d+");
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
            // System.out.println("ERROR AFTER SYMBOL");
            // System.exit(0);
        }
        return result;
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
}
