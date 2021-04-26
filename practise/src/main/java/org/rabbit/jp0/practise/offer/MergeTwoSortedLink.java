package org.rabbit.jp0.practise.offer;

/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *     比较两个链表的首结点，哪个小的的结点则合并到第三个链表尾结点，并向前移动一个结点。
 *     步骤一结果会有一个链表先遍历结束，或者没有
 *     第三个链表尾结点指向剩余未遍历结束的链表
 *     返回第三个链表首结点
 *
 * * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class MergeTwoSortedLink {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        //新建一个头节点，用来存合并的链表。
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;

            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }

        }
        //把未结束的链表连接到合并后的链表尾部
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return newList.next;
    }


    //Method2: 递归
    public ListNode MergeWithCircle(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }
}
