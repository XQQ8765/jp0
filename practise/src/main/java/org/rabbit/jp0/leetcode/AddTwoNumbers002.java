package org.rabbit.jp0.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 【Leetcode】002 Add Two Numbers
 * 题目
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * ————————————————
 * 原文链接：https://blog.csdn.net/liyazhou0215/article/details/77017119
 * https://sololo.blog.csdn.net/article/details/52914703 【LeetCode】2. Add Two Numbers 解题报告 ---3种解法
 * -----------------
 * 题目大意
 * 　　有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
 *
 * 解题思路
 * 　　对两个链表都从第一个开始处理，进行相加，结果再除以10求商，作为下一位相加的进位，同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
 */
public class AddTwoNumbers002 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2).addNext(4).addNext(3);
        ListNode list2 = new ListNode(5).addNext(6).addNext(4);

        ListNode resultList = addTwoNumbers(list1, list2);
        while(resultList != null) {
            System.out.println(resultList.val + " -> ");
            resultList = resultList.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode addNext(int nextV) {
            ListNode nextNode = new ListNode(nextV);
            next = nextNode;
            return next;
        }

        public int getVal() {
            return val;
        }
    }
}


