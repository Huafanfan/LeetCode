package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yifan.zhangyf
 * @date 2022/9/1 9:09 PM
 */
public class FinalPricesWithASpecialDiscountInAShop1475 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<prices.length; i++){
            while (!stack.isEmpty() && prices[stack.getLast()] >= prices[i]){
                int idx = stack.pollLast();
                ans[idx] = prices[idx] - prices[i];
            }
            stack.addLast(i);
            ans[i] = prices[i];
        }
        return ans;
    }
}
