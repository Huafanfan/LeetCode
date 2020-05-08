package com.huafanfan;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/8 17:13
 */
public class FactorialTrailingZeroes0172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    /**
     * 计算质因数里面有多少个5
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
