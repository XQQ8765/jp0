package org.rabbit.jp0.practise;

/**
 * 7.请写出求n！的算法。
 */
public class FactorialApp {
    private static long cacl(long i) {
        if (i <= 1) {
            return 1;
        }
        return i * cacl(i-1);
    }

    public static void main(String[] args) {
        long result = cacl(2);
        System.out.println(result);
    }
}
