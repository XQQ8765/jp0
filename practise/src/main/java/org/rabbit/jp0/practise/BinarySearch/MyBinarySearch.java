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
        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (arr[start] == k) {
                return end;
            } else {
                return -1;
            }
        }

        int mid = start + (end - start) / 2;;
        System.out.println("start:"+start + ", end=" + end + ", k=" + k + ", mid="+mid);
        if (arr[mid] == k) {
            return mid;
        }

        int index = binarySearch(arr, 0, mid-1, k);
        if (index != -1) {
            return index;
        }
        index = binarySearch(arr, mid+1, end, k);
        if (index != -1) {
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyBinarySearch mbs = new MyBinarySearch();
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: "+mbs.binarySearch(arr, 14));
        int[] arr1 = {6,34,78,123,432,900};
        System.out.println("Key 432's position: "+mbs.binarySearch(arr1, 432));
    }
}
