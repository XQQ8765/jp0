package org.rabbit.jp0.practise.offer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
 *   1、确定root；
 *   2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
 *   3、遍历右子树，若发现有小于root的值，则直接返回false；
 *   4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
 * ————————————————
 * 版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/mine_song/article/details/64121769
 */
public class AfterSequenceForBinaryTree {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        // 调用函数，java没有指针，要用下标模拟指针，新建函数判断
        return IsTreeBST(sequence, 0, sequence.length - 1);
    }

    private boolean IsTreeBST(int[] sequence, int start, int end) {
        // index是指示找到第一个大于左子树的结点
        int index = start;
        for (; index < end; index++)
            if (sequence[index] > sequence[end])
                break;
        // 若右子树有小于跟结点的值，返回false
        for (int i = index; i < end; i++)
            if (sequence[i] < sequence[end])
                return false;
        return IsTreeBST(sequence, start, index - 1) && IsTreeBST(sequence, index, end - 1);
    }


    // 非递归 
    // 非递归也是一个基于递归的思想：
    // 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
    // 最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件即可，
    // 即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理 
    // 对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
    // 只需看看右子树的右子树是否符合要求即可
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        int len = sequence.length;
        while (--len > 0) {
            int i = 0;
            while (sequence[i] < sequence[len])
                i++;
            while (sequence[i] > sequence[len])
                i++;
            if (i != len)
                return false;

        }
        return true;
    }
}
