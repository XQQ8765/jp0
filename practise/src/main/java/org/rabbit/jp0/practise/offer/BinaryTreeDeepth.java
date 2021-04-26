package org.rabbit.jp0.practise.offer;

/**
 * 二叉树的深度及判断是否为平衡二叉树
 *
 * 输入一棵二叉树，1，判断该二叉树是否是平衡二叉树，2，计算深度
 */
public class BinaryTreeDeepth {
    // 注意使用全局变量
    boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        lengthOfTree(root);
        return isBalance;
    }

    private int lengthOfTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = lengthOfTree(root.left);
        int right = lengthOfTree(root.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return Math.max(left, right) + 1;

    }

    // 每个结点被遍历多次的解法
    public boolean IsBalancedTree(TreeNode root) {
        // 空树为true
        if (root == null)
            return true;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        return IsBalancedTree(root.left)
                && IsBalancedTree(root.right);
    }

    // 计算树的深度，注意加1
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        // 注意最后加1，因为左右子树的深度大的+根节点的深度1
        return Math.max(TreeDepth(root.left),
                TreeDepth(root.right)) + 1;
    }
}
