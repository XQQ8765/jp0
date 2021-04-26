package org.rabbit.jp0.practise.offer;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * 使用中序遍历，的顺序就是二叉搜索时从小到大的排序。
 */
public class BinaryTreeKthNode {
    // 使用递归实现，java无引用注意使用全局变量
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null)
                return node;

            if (++index == k)
                return pRoot;

            node = KthNode(pRoot.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

    // 使用栈实现
    TreeNode KthNodeWithStack(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if (--k == 0)
                    return pRoot;
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
