package org.rabbit.jp0.practise.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * 可以用两个Queue来轮流存储数据，当执行pop，top等指令时，因为要返回Queue中最后一个element，所以把之前的所有elements压到另外一个空queue中，剩下唯一一个element的时候，实现poll返回。依次交替
 *
 * 注意事项：pop，top等取出行为，要先检查两个queue是不是都为空
 * ————————————————
 * 原文链接：https://blog.csdn.net/mine_song/article/details/63322097
 * leetcode解题之225 # Implement Stack using Queuest Java版 (用两个队列实现一个栈）
 */
public class TwoQueueForStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public TwoQueueForStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (q2.isEmpty()) {
            q1.offer(x);
        } else
            q2.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!q2.isEmpty()) {
            if (q2.size() == 1)
                return q2.poll();
            q1.offer(q2.poll());
        }
        while (!q1.isEmpty()) {
            if (q1.size() == 1)
                return q1.poll();
            q2.offer(q1.poll());
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        while (!q2.isEmpty()) {
            if (q2.size() == 1) {
                int x = q2.peek();
                q1.offer(q2.poll());
                return x;
            }

            q1.offer(q2.poll());
        }
        while (!q1.isEmpty()) {
            if (q1.size() == 1) {
                int x = q1.peek();
                q2.offer(q1.poll());
                return x;
            }
            q2.offer(q1.poll());
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
