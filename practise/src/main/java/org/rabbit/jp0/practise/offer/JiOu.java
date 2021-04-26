package org.rabbit.jp0.practise.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class JiOu {

    //1.使用冒泡排序，前偶后奇就交换
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 前偶后奇数就交换
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
            }
        }
    }

    //2.空间换时间，使用额外数组。
    public void reOrderArray2(int[] array) {
        int[] newArr = new int[array.length];
        //newArr的下标计数器
        int j = 0;
        for (int i = 0; i < array.length; i++)
            if ((array[i] & 1) == 1) {
                newArr[j] = array[i];
                j++;
            }
        for (int i = 0; i < array.length; i++)
            if ((array[i] & 1) == 0) {
                newArr[j] = array[i];
                j++;
            }
        for (int i = 0; i < array.length; i++)
            array[i] = newArr[i];
    }
}
