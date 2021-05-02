package org.rabbit.jp0.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * https://blog.csdn.net/weixin_30569001/article/details/97271166 LeetCode高频题目（100）汇总-Java实现
 * 【Leetcode】001 Two Sum
 * 题目
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * ————————————————
 * 原文链接：https://blog.csdn.net/liyazhou0215/article/details/77017066 【Leetcode】001 Two Sum
 */
public class TwoSum001 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 22;
        int[] results = twoSum(nums, target);
        Arrays.stream(results).forEach(System.out::println);
    }

    /**
     * Solution: Use map
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no solution.");
    }
}
