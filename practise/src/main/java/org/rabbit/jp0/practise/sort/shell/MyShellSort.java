package org.rabbit.jp0.practise.sort.shell;

public class MyShellSort {
    public static void main(String[] args) {
        //int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {9, 10, 3, 3, 1, 6, 9, 4, 6, 8};
        shellSort(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    private static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int step= arr.length/2; step > 0; step = step /2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int j = step; j < arr.length; j++) {
                //对步长区间中具体的元素进行比较插入排序
                int k = j;
                while(k>=0) {
                    int prevK = k - step;
                    if (prevK >= 0) {
                        if (arr[k] < arr[prevK]) {//交换
                            int tmp = arr[k];
                            arr[k] = arr[prevK];
                            arr[prevK] = tmp;
                        }
                    }
                    k = prevK;
                }
            }
        }
    }
}
