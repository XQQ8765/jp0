package org.rabbit.jp0.practise.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。（使用两个栈实现）
 */
public class BinaryTreePrintAsZhi {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        stack.add(pRoot);
        int flag = 0;
        ArrayList<Integer> lay = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            lay.add(node.val);
            // 如果当前是从左到右遍历，按左子树右子树的顺序添加
            if (flag == 0) {
                if (node.left != null)
                    nextStack.add(node.left);
                if (node.right != null)
                    nextStack.add(node.right);
            } else// 如果当前是从右到左遍历，按右子树左子树的顺序添加
            {
                if (node.right != null)
                    nextStack.add(node.right);
                if (node.left != null)
                    nextStack.add(node.left);
            }
            if (stack.isEmpty()) {
                // 交换两个栈
                Stack<TreeNode> tmp = stack;
                stack = nextStack;
                nextStack = tmp;
                // 标记下一层处理的方向
                flag = 1 - flag;
                ans.add(new ArrayList<>(lay));
                lay.clear();
            }
        }
        return ans;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
