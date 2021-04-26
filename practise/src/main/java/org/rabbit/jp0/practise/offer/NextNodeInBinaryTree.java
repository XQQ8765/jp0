package org.rabbit.jp0.practise.offer;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 首先知道中序遍历的规则是：左根右，然后作图
 *
 *
 *
 * 结合图，我们可发现分成两大类：1、有右子树的，那么下个结点就是右子树最左边的点；（eg：D，B，E，A，C，G） 2、没有右子树的，也可以分成两类，a)是父节点左孩子（eg：N，I，L） ，那么父节点就是下一个节点 ； b)是父节点的右孩子（eg：H，J，K，M）找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置。如果没有(eg：M)，那么他就是尾节点。
 * ————————————————
 * 版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/mine_song/article/details/64121769
 */
public class NextNodeInBinaryTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        // 如果有右子树，则找右子树的最左节点
        if (pNode.right != null) {
            // 如果此时pNode没有左子树，那么它就是下一个结点
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        // 非跟结点，并且没有右子树
        while (pNode.next != null) {
            // 找到一个结点是该其父亲的左孩子
            if (pNode.next.left == pNode)
                return pNode.next;
            pNode = pNode.next;
            // 找到返回父节点,此时pNode.next也有可能为空
        }
        // 是跟结点且没有左子树
        return null;
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // 父节点
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
