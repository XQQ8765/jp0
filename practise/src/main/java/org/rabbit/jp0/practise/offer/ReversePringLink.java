package org.rabbit.jp0.practise.offer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class ReversePringLink {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    //Method1: 使用递归实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    //Method2: 使用Stack实现
    public ArrayList<Integer> printListFromTailToHeadWithStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}