package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/4/30 01:31
 */
public class BestTimeToBuyAndSellStock0121 {
    public static void main(String[] args){
        int[] a = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

    /**
     * 暴力法
     * 时间复杂度：O(n^2)。循环运行 n(n−1)/2次。
     * 空间复杂度：O(1)。只使用了常数个变量。
     * @param prices
     * @return int
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                max = Math.max(prices[j]-prices[i],max);
            }
        }
        return Math.max(max, 0);
    }

    /**
     * 一次遍历
     * 时间复杂度：O(n)，只需要遍历一次。
     * 空间复杂度：O(1)，只使用了常数个变量。
     * @param prices
     * @return
     */
    public static int maxProfitOnce(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}
