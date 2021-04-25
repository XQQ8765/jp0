package org.rabbit.jp0.practise.offer;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *  https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class JumpFloor {
    //Method1: 递归
    public int JumpFloorWithRecircle(int target) {
        int result = 0;
        if (target > 0) {
            if (target <= 2)
                return target;
            else
                return result = JumpFloor(target - 1) + JumpFloor(target - 2);
        }
        return result;
    }

    //Method2
    public int JumpFloor(int target) {
        int fn1 = 1;
        int fn2 = 2;
        int res = 0;
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        for (int i = 3; i <= target; i++) {
            res = fn1 + fn2;
            fn1 = fn2;
            fn2 = res;
        }
        return res;
    }
}
