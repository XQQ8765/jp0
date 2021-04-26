package org.rabbit.jp0.practise.offer;

import java.util.Stack;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 二叉树是否对称，只要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先右后左两种方法，只要两次结果相等就说明这棵树是一颗对称二叉树。
 * ————————————————
 * 版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/mine_song/article/details/64121769
 */
public class BinaryTreeIsMirror {
    // 迭代版本
    boolean isSymmetricalWithIter(TreeNode pRoot) {
        Stack<TreeNode> s = new Stack<>();
        if (pRoot == null)
            return true;
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.isEmpty()) {
            TreeNode tmp1 = s.pop();
            TreeNode tmp2 = s.pop();
            // 注意if顺序，及其条件
            if ((tmp1 != null && tmp2 == null) || (tmp1 == null && tmp2 != null))
                return false;
            if (tmp1 != null && tmp2 != null) {
                if (tmp1.val != tmp2.val)
                    return false;
                s.push(tmp1.left);
                s.push(tmp2.right);
                s.push(tmp1.right);
                s.push(tmp2.left);
            }
        }
        return true;
    }

    // 递归版本
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        // 类似前序遍历
        if (root1.val != root2.val)
            return false;
        // 避免数字重复，要遍历空节点
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    //Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
