package org.rabbit.jp0.practise.sort.insert;

/**
 * http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
 * https://zhuanlan.zhihu.com/p/64658779 排序算法-插入排序（Java实现）
 */
public class InsertionSortExample {
        public static void main(String a[]){
            int[] arr1 = {10,34,2,56,7,67,88,42};
            int[] arr2 = doInsertionSort(arr1);
            for(int i:arr2){
                System.out.print(i);
                System.out.print(", ");
            }
        }

        public static int[] doInsertionSort(int[] input){
            int temp;
            for (int i = 1; i < input.length; i++) {
                for(int j = i ; j > 0 ; j--){
                    if(input[j] < input[j-1]){
                        temp = input[j];
                        input[j] = input[j-1];
                        input[j-1] = temp;
                    }
                }
            }
            return input;
        }
}
