package org.rabbit.jp0.practise;

/**
 * https://blog.csdn.net/qauchangqingwei/article/details/82151271
 * 6.用递归方法实现正序显示数组元素。例如String[] s = {“a”,”b”,”c”,”d”};
 *
 * 方法声明如下：
 *
 * void print(String[] s,int i){ }
 *
 * 解答：参数 i 是指打印string数组的起始位置，原理是正序打印s从第0个开始的所有字符串，等价于先打印第0个，在打印s中从第一个开始的所有字符串，如此递归
 */
public class PrintArray {

    private static void printArray(int[] array, int i) {
        if (i < array.length) {
            System.out.println(array[i]);
            printArray(array, i+1);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 8, 2, 10};
        printArray(array, 0);
    }
}
