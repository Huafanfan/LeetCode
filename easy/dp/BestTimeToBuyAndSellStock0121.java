package easy.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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
        if (prices.length < 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if ((prices[i]-minPrice)>maxProfit){
                maxProfit = prices[i] - minPrice;
            }
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public int maxProfitDeque(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        stack.offerLast(prices[0]);
        for (int i=1; i<prices.length; i++){
            if (prices[i] <= stack.peekLast()) {
                int index = stack.size() - 1;
                for (; index >= 0; index--) {
                    if (stack.peekLast() < prices[i]) {
                        break;
                    }
                    stack.pollLast();
                }
            }
            stack.offerLast(prices[i]);
            res = Math.max(res, stack.peekLast() - stack.peekFirst());
        }
        return res;
    }
}
