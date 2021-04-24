package org.rabbit.jp0.practise.sort.selection;

import java.util.Arrays;

/**
 * 选择排序
 * 也用简单的话来说，就是从第一个数开始，与后面所有的数相比较，找出最小的数，放在第一个位置，以此类推，每一轮确定一个相对于这一轮最小的数
 * https://blog.csdn.net/weixin_39843338/article/details/109762351
 *
 * 二者区别：
 * (1)冒泡排序是比较相邻位置的两个数，而选择排序是按顺序比较，找最大值或者最小值；
 * (2)冒泡排序每一轮比较后，位置不对都需要换位置，选择排序每一轮比较都只需要换一次位置；
 * (3)冒泡排序是通过数去找位置，选择排序是给定位置去找数；
 * **冒泡排序优缺点：**优点:比较简单，空间复杂度较低，是稳定的；
 * 缺点:时间复杂度太高，效率慢；
 * **选择排序优缺点：**优点：一轮比较只需要换一次位置；
 * 缺点：效率慢，不稳定(举个例子5，8，5，2，9 我们知道第一遍选择第一个元素5会和2交换，那么原序列中2个5的相对位置前后顺序就破坏了)。
 */
public class MySelectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i=0; i< arr.length-1; ++i) {
            int minIndex = i;
            for (int j=i+1; j< arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    minIndex = j;//找出最小值所在的index
                }
            }

            if (minIndex != i) {
                int v = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = v;
            }
            System.out.println("sort i:"+i);
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 6, 2};
        MySelectionSort.sort(arr);
        System.out.println("After sort: ");
        Arrays.stream(arr).forEach(System.out::println);

    }
}
