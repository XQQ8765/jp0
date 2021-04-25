package org.rabbit.jp0.practise.BinarySearch;

import org.rabbit.jp0.practise.BinarySearch.example.NormalBinarySearch;

public class MyBinarySearch {
    /**
     * @param arr - int[]
     * @param k - int
     * @return int - Index, not found will return -1
     */
    public int binarySearch(int[] arr, int k) {
        if (arr == null) {
            return -1;
        }
        return binarySearch(arr, 0, arr.length-1, k);
    }

    private int binarySearch(int[] arr, int start, int end, int k) {
        //System.out.println("start:" + start + ", end:" + end +", k:" + k);
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (k == arr[mid]) {
            return mid;
        } else if (k < arr[mid]) {
            return binarySearch(arr, 0, mid-1, k);
        } else {
            return binarySearch(arr, mid+1, end, k);
        }
    }

    public static void main(String[] args) {
        MyBinarySearch mbs = new MyBinarySearch();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: "+mbs.binarySearch(arr, 14));
        System.out.println("Key 7's position: "+mbs.binarySearch(arr, 7));
        int[] arr1 = {6,34,78,123,432,900};
        System.out.println("Key 432's position: "+mbs.binarySearch(arr1, 432));
    }
}
