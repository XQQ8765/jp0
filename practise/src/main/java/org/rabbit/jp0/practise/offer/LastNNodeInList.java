package org.rabbit.jp0.practise.offer;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 快慢指针，让快指针先走k步，然后慢指针开始走，若快指针走到末尾(为null)，就是慢指针指向的就是倒数第k个结点
 * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class LastNNodeInList {

    public static ListNode findKthToTail(ListNode head, int k) {
        ListNode front = head;
        int i = 0;
        for (; front != null && i < k; i++) {
            front = front.next;
        }
        // 如果k大于链表的长度或者k小于0，返回null；
        if (i != k)
            return null;
        ListNode behind = head;
        while (front != null) {
            front = front.next;
            behind = behind.next;
        }
        // 若k等于0，则behind为null
        return behind;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(2).addNext(3).addNext(4).addNext(5).addNext(6).addNext(7);

        ListNode kthNode = findKthToTail(head, 1);
        if (kthNode != null) {
            System.out.println(kthNode.getVal());
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        ListNode addNext(int val) {
            next = new ListNode(val);
            return next;
        }
    }


}

