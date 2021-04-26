package org.rabbit.jp0.practise.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class NotDuplicateCharInString {
    // 使用map记录出现的次数
    HashMap<Character, Integer> map = new HashMap<>();
    // 使用list记录当前的所有输入的字符，不能使用set等
    ArrayList<Character> list = new ArrayList<Character>();

    // Insert one char from stringstream
    private void Insert(char ch) {
        if (map.containsKey(ch))
            map.put(ch, map.get(ch) + 1);
        else
            map.put(ch, 1);
        list.add(ch);
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Character c : list)
            if (map.get(c) == 1)
                return c;
        return '#';
    }
}
