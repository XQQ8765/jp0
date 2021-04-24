package org.rabbit.jp0.practise.sort.merge;

import org.rabbit.jp0.practise.sort.selection.MySelectionSort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/of-fanruice/p/7678801.html Java实现归并排序
 */
public class ExampleMergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 6, 2, 8, 3, 1};
        int[] sortedArr = ExampleMergeSort.sort(arr);
        System.out.println("After sort: ");
        //Arrays.stream(sortedArr).forEach(System.out::println);
        System.out.println(Arrays.toString(sortedArr));
    }


    public static int[] sort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        return sort(a, 0, a.length-1);
    }
    private static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
}
