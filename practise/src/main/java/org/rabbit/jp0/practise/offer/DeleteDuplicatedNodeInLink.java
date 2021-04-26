package org.rabbit.jp0.practise.offer;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 1，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5；
 * 2，重复的结点保留一个，如1->4->4->5处理后为1->4->5
 */
public class DeleteDuplicatedNodeInLink {

    //重复结点不保留
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        int myfirst = -1;
        if (myfirst == pHead.val)
            myfirst = -2;
        // 新建一个节点，防止头结点要被删除
        ListNode head = new ListNode(myfirst);
        head.next = pHead;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            // 此while跳过重复结点
            while (q.next != null && q.val == q.next.val)
                q = q.next;
            // 如果指针移动了
            if (p.next != q) {
                q = q.next;
                // 让p指向非重复结点后的第一个
                p.next = q;
            } else {
                p = q;
                q = q.next;
            }

        }
        return head.next;
    }

    //重复结点保留
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
