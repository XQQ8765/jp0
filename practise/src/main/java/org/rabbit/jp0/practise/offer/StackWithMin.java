package org.rabbit.jp0.practise.offer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class StackWithMin {
    /*
     * 思路：用一个栈stack保存数据，用另外一个栈min保存依次入栈最小的数
     * 比如，stack中依次入栈，5, 4, 3, 8, 10,11,12,1
     * 则min依次入栈，5, 4, 3, 3, 3, 3, 3, 1
     * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则入stack的栈顶元素。
     * 保持stack中和min中保持相同个数的元素
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        // 如果min为空或者node比min栈中的元素小，则入min栈
        if (minStack.size() == 0 || minStack.peek() > node) {
            minStack.push(node);
        }
        // 否则把min栈中的顶部元素入栈
        else minStack.push(minStack.peek());
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
