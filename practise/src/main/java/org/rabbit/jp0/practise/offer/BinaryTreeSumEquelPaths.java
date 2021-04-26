package org.rabbit.jp0.practise.offer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class BinaryTreeSumEquelPaths {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        /*
         * if (root.left != null) { FindPath(root.left, target);
         * list.remove(list.size() - 1); } if (root.right != null) {
         * FindPath(root.right, target); list.remove(list.size() - 1); }
         */
        // 继续遍历左右结点
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 在返回父节点之前，在路径上删除该结点
        list.remove(list.size() - 1);
        return listAll;
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
