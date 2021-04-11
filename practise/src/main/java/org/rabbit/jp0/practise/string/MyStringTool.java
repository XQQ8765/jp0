package org.rabbit.jp0.practise.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 一些字符串相关面试题的java实现
 * 1.字符串右移n位
 * 2.字符串反转
 * 3.返回任意整数对应二进制形式中的1的个数
 * 4.显示字符串中字符的所有排序
 * http://m.myexceptions.net/program/838469.html
 */
public class MyStringTool {
    private static String rightMove(String s, int n) {
        if (s == null) {
            return null;
        }
        if (n < 0) {
            throw new IllegalArgumentException("Param n:" + n + " is illegal.");
        }
        if (n > s.length()) {
            n = n % s.length();
        }

        if (n == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); ++i) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //返回任意整数对应二进制形式中的1的个数
    private static int oneStat(int i) {
        String binaryStr = Integer.toBinaryString(i);
        int num = 0;
        for (int k=0; k<binaryStr.length(); ++k) {
            if (binaryStr.charAt(k) == '1') {
                num++;
            }
        }
        System.out.println("i:" + i + ", binaryStr:" + binaryStr + ", 1-num:" + num);
        return num;
    }

    //4.显示字符串中字符的所有排序
    public static void printAllSortList(String s) {
        if (s == null || s.length() == 0) {
            System.out.println(s);
        }
        /**
         * Converting char[] Array to List in Java.
         * https://stackoverflow.com/questions/15590675/converting-char-array-to-list-in-java
         */
        List<Character> charList = s.chars().mapToObj(c -> (char) c).collect(toList());
        for (int i=0; i< charList.size(); ++i) {
            System.out.print(charList.get(i));
            StringBuilder sb = new StringBuilder();
            char c = charList.remove(i);
            sb.append(c);
            /**
             Converting List<Character> to char[] and then to String,
             see: https://stackoverflow.com/questions/7702035/converting-listcharacter-to-char-and-then-to-string
             */
            String newStr = Arrays.stream(charList.toArray()).map(String::valueOf)
                    .collect(Collectors.joining());
            //System.out.println(newStr);
            printAllSortList(newStr);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello".split("")[1]);
        System.out.println("xxxxx");
        String[] words = new String[]{"Hello","World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        a.forEach(System.out::print);

        String s = "1234567890";
        String result = rightMove(s, 15);
        System.out.println(result);

        result = rightMove(s, 0);
        System.out.println(result);

        result = rightMove(s, 1);
        System.out.println(result);

        oneStat(15);
        oneStat(15890);
        oneStat(9);
        oneStat(0);
        oneStat(-15);

        printAllSortList("abcd");
    }
}
