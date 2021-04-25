package org.rabbit.jp0.practise.offer;

/**
 * 1.二维数组中的查找
 * 题目描述
 *
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 *  [1,  4, 7, 11, 15],
 *  [2,  5, 8, 12, 19],
 *  [3,  6, 9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target=5，返回true。
 * 给定target=20，返回false。
 * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 *
 * 思路:
 * 矩阵是有序的，从右上角来看，向左数字递减，向下数字递增，
 * 因此从右上角开始查找，当要查找数字比左下角数字大时。下移
 * 要查找数字比左上角数字小时，左移
 */
public class TwoDiamentionArray {
    public boolean Find(int[][] array, int target) {
        int len = array.length - 1;
        int col = 0;
        while ((len >= 0) && (col < array[0].length)) {
            if (array[len][col] > target) {
                len--;
            } else if (array[len][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
