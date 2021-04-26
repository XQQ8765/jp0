package org.rabbit.jp0.practise.offer;

import java.util.HashSet;

/**
 * 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoopInLink {

    //使用set
    public ListNode EntryNodeOfLoopWithSet(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        // set.add()返回值是boolean
        while (pHead != null) {
            if (!set.add(pHead))
                return pHead;
            pHead = pHead.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
