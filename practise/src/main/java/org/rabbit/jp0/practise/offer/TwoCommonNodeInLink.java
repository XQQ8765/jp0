package org.rabbit.jp0.practise.offer;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走（因为2个链表用公共的尾部）
 */
public class TwoCommonNodeInLink {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLenth(pHead1);
        int len2 = findListLenth(pHead2);
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;
        // 先在长链表上走上几步，在同时在两个链表上遍历
        if (len1 - len2 > 0)
            current1 = walkStep(current1, len1 - len2);
        else
            current2 = walkStep(current2, len2 - len1);
        while (current1 != null && current2 != null) {
            if (current1 == current2)
                return current1;
            current1 = current1.next;
            current2 = current2.next;
        }
        return null;
    }

    private ListNode walkStep(ListNode cur, int step) {
        // 从step~1
        while (step-- > 0)
            cur = cur.next;
        return cur;
    }

    // 计算链表长度
    private int findListLenth(ListNode head) {
        if (head == null)
            return 0;
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
