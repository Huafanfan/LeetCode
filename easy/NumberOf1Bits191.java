package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/20 13:21
 */
public class NumberOf1Bits191 {

    /**
     * 循环和位移动
     * 时间复杂度：O(1) 。运行时间依赖于数字 n 的位数。由于这题中 n 是一个 32 位数，所以运行时间是 O(1) 的。
     * 空间复杂度：O(1) 。没有使用额外空间。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        for(int i=0;i<=31;i++){
            if((1&(n>>i))==1){
                count++;
            }
        }
        return count;
    }

    /**
     * 位操作的小技巧
     * 时间复杂度：O(1) 。运行时间与 n 中位为 1 的有关。在最坏情况下， n 中所有位都是 1 。对于 32 位整数，运行时间是 O(1) 的。
     * 空间复杂度：O(1) 。没有使用额外空间。
     * @param n
     * @return
     */
    public int hammingWeightSkill(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
