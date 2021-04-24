package org.rabbit.jp0.practise.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序是比较相邻位置的两个数；
 * 冒泡排序用简单的话来讲就是，从左往右，两两相互比较大小，左边的大就交换位置，循环往复，把较大的放后面。
 * https://blog.csdn.net/qq_45867979/article/details/105844421
 */
public class MyBubbleSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i=0; i< arr.length-1; ++i) {
            for (int j=i+1; j< arr.length; ++j) {
                if (arr[i] > arr[j]) {//这里指左边比右边大的话就交换位置, 让大的值冒到右边
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println("sort i:"+i);
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 6, 2};
        MyBubbleSort.sort(arr);
        System.out.println("After sort: ");
        Arrays.stream(arr).forEach(System.out::println);

    }
}
