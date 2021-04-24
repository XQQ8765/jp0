package org.rabbit.jp0.practise.stack;

import java.util.Stack;

/**
 * 两个Stack实现一个队列
 */
public class TwoStackAsQueue implements MyQueue<Integer> {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    @Override
    public Integer pop() {
        Integer popElement = null;
        if (!stack2.empty()) {
            popElement = stack2.pop();
        } else {
            while(!stack1.empty()) {
                Integer i = stack1.pop();
                stack2.push(i);
            }
            if (stack2.empty()) {
                popElement = null;
            } else {
                popElement = stack2.pop();
            }
        }
        System.out.println("Pop:" + popElement);
        return popElement;
    }

    @Override
    public void push(Integer i) {
        System.out.println("Push:" + i);
        stack1.push(i);
    }

    public static void main(String[] args) {
        TwoStackAsQueue queue = new TwoStackAsQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
        queue.push(5);
        queue.push(6);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();

        queue.pop();
    }
}

interface MyQueue<T> {
    T pop();

    void push(T t);
}