package org.rabbit.jp0.practise.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class BinaryTreePrintMultipleLines {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        // 下一层需要打印的结点数
        int nextLevel = 0;
        // 当前层需要打印的结点数
        ArrayList<Integer> tmp = new ArrayList<>();
        int toBePrinted = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                q.offer(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                ans.add(new ArrayList<>(tmp));
                tmp.clear();
                // 下次打印的是q的所有结点
                // or toBePrinted=q.size();省去nextLevel变量
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return ans;
    }
}
