package org.rabbit.jp0.practise.offer;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * ————————————————
 * 版权声明：本文为CSDN博主「mine_song」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接： https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class ReroteArray {

    /**
     * Method1: 使用二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
                // high = high - 1;可以避免low，high,mid相等的找不到最小值情况。
                // int[] array={1,0,1,1,1};
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0)
            return 0;
        // 避免i+1越界，i要小于array.length - 1
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        // 所有元素相等时候或者未旋转，返回array[0]
        return array[0];
    }

}
