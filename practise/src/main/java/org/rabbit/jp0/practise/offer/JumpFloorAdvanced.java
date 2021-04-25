package org.rabbit.jp0.practise.offer;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Solution: 2^(n-1)
 * https://blog.csdn.net/mine_song/article/details/64121769 剑指Offer——编程题的Java实现（更新完毕……）
 */
public class JumpFloorAdvanced {
    //Method1: 递归
    public int JumpFloorII(int target) {
        if (target < 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    //2^(n-1)可以用位移操作进行
    public int JumpFloorII2(int target) {
        return 1 << --target;
    }

    public int JumpFloorII3(int target) {
        int jumpFlo = 1;
        while (--target > 0) {
            jumpFlo *= 2;
        }
        return jumpFlo;
    }

}
