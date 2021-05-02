package org.rabbit.jp0.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 【LeetCode】003 Longest Substring Without Repeating Characters
 * 题目
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given “abcabcbb”, the answer is “abc”, which the length is 3.
 * <p>
 * Given “bbbbb”, the answer is “b”, with the length of 1.
 * <p>
 * Given “pwwkew”, the answer is “wke”, with the length of 3. Note that the answer must be a substring, “pwke” is a subsequence and not a substring.
 * ————————————————
 * 版权声明：本文为CSDN博主「LYZ0907」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/liyazhou0215/article/details/77510034
 * <p>
 * https://blog.csdn.net/x273591655/article/details/84958536 【LeetCode题解】3_无重复字符的最长子串（Longest-Substring-Without-Repeating-Characters）
 */
public class LongestSubstring003 {
    /**
     * 解法一：暴力枚举法（Time Limit Exceeded）
     * 思路
     * 这种方法采用的思路是：列举出字符串中所有的子串，然后判断字串是否不包含重复字符，
     * 如果是，则将该子串的长度与当前保存的最长长度（用一个变量存储）进行比较，保留二者的大者。
     * 遍历完所有的子串后，将可以得到不包含重复元素的最长子串的长度。
     * <p>
     * 时间复杂度：O(n^3)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; ++i) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 解法二：滑动窗口（双指针）
     * 思路
     * 解法二借助于一个大小可变的滑动窗口。
     * 当窗口中不存在重复字符时，窗口的右边界向右滑动（增加窗口中的字符数），如果窗口中存在重复字符，则将窗口的左边界向右滑动，减少窗口中的字符数。
     * 并且，每次增加新的字符时，都与当前最长子串的长度进行比较，保留二者的大者。
     * 当窗口的右边界抵达字符串的末尾时，遍历结束，返回保存的最长子串的长度。滑动窗口可以采用集合进行表示。
     * <p>
     * 时间复杂度：O(n)，其中 n nn 表示字符串的长度。最坏情况下（例如：字符串 bbbbbb），需要 2 n 2n2n 次操作
     * ————————————————
     * https://blog.csdn.net/x273591655/article/details/84958536 【LeetCode题解】3_无重复字符的最长子串（Longest-Substring-Without-Repeating-Characters）
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0, l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while (l < n && r < n) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
                ans = Math.max(r - l, ans);
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring003 app = new LongestSubstring003();
        //System.out.println(app.lengthOfLongestSubstring("pwwkew"));
        System.out.println(app.lengthOfLongestSubstring1("pwwkew"));
        System.out.println(app.lengthOfLongestSubstring1("au"));
        //System.out.println(app.lengthOfLongestSubstring("ab"));
    }
}
