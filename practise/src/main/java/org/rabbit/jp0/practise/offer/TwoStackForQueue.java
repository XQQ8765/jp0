package org.rabbit.jp0.practise.offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 有两个栈，栈1和栈2.当入栈的时候，我们将它全放进栈1中，当需要出栈的时候，我们将栈1出栈到栈2中，然后再将栈2依次出栈。所以入栈的时候，思路很简单;当需要出栈的时候，我们用API提供的方法while(stack1.isEmpty())来将所有栈1的元素压入栈2中，然后将栈2弹出就可以.
 * ————————————————
 * 版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/mine_song/article/details/64121769
 */
public class TwoStackForQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
