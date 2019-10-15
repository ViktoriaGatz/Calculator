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
    private BigInteger answeR = BigInteger.valueOf(0);

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

    public BigInteger getAnsweR() {
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

    public static BigInteger Rachet(Stack<String> stack) {
        // System.out.println(stack);
        // System.out.println(stack.peek().toString());
        String st = new String(stack.peek().toString());
        int n = stack.size();
        BigInteger answer = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            String ss = new String(stack.peek().toString());
            String s = Pattern1(ss, ".+?\\)"); // Из последнего элемента стека берём только часть до первой ")"
            answer = Pattern2(s);
            // System.out.println(answer);
            String strBuf = answer.toString();
            st = ss.replaceFirst(stack.peek().toString(), strBuf);
        }
        return answer;
    }

    public static BigInteger Pattern2(String str) {
        String ss = new String(str);
        ss = ss.replaceAll("\\)", ""); // Убираем последнюю скобочку, получаем "чистое" выражение: 733+80*95
        ss =  Pattern3(ss, "\\*"); // Получаем
        ss =  Pattern3(ss, "\\*"); // Получаем
        ss =  Pattern3(ss, "/");
        ss =  Pattern3(ss, "/");
        ss =  Pattern3(ss, "-");
        ss =  Pattern3(ss, "-");
        ss =  Pattern3(ss, "\\+");
        ss =  Pattern3(ss, "\\+");
        ss =  Pattern3(ss, "\\^");
        ss =  Pattern3(ss, "\\^");
        System.out.println("SS = " + ss);
        BigInteger answer = new BigInteger(ss);
        System.out.println("ANSWER = " + answer);
        return answer;
    }

    public static String Pattern3(String str, String c) { // String // Выполнение действий (первое - умножение)
        String st = new String(str);
        if (contains("(.*)" + c + "(.*)", str)) { // Если строка содержит знак
            BigInteger first = BigInteger.valueOf(-1234567890);
            BigInteger second = BigInteger.valueOf(-1234567890);
            BigInteger buff = BigInteger.valueOf(-1234567890);
            BigInteger answer = BigInteger.valueOf(-1234567890);
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
                            // answer = first * second;
                            answer = first.multiply(second);
                            break;
                        case "\\+":
                            // answer = first + second;
                            answer = first.add(second);
                            break;
                        case "-":
                            // answer = second - first;
                            answer = second.subtract(first);
                            break;
                        case "/":
                            // answer = second / first;
                            answer = second.divide(first);
                            break;
                        // case "^":
                        //     BigInteger first = a.pow(bb);
                        //     BigInteger a = new BigInteger(newNumber);
                        //     BigInteger b = BigInteger.valueOf(1000);
                        //     int bb = b.intValue();
                        default:
                            break;
                    }
                    // System.out.println(Integer.toString(answer));
                    // Замена
                    String strBuf1 = second.toString();
                    String strBuf2 = answer.toString();
                    String strBuf3 = answer.toString();
                    st = st.replaceFirst(strBuf1 + c + strBuf2, strBuf3);
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

    public static BigInteger Pattern4(String word) { // Должно вернуть последнее число в строке
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
    BigInteger bigInt = new BigInteger(String.valueOf(result));
    return bigInt;
    }

    public static BigInteger Pattern5(String word) { // Должно вернуть первое число в строке
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
        BigInteger bigInt = new BigInteger(String.valueOf(result));
        return bigInt;
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
}
