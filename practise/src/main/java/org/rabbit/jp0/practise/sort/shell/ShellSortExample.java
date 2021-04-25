package org.rabbit.jp0.practise.sort.shell;

/**
 * https://zhuanlan.zhihu.com/p/85987364 用Java首先希尔排序
 * https://segmentfault.com/a/1190000013967025
 *
 * 希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），是直接插入排序算法的一种更高效的改进版本。
 */
public class ShellSortExample {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        shellSort(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static void shellSort(int[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //开始直接排序算法，先来一轮直接排序（底层干的还是插入排序干的活～）
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
    }
}
