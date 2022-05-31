package neetcode.slidingwindows;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/31 10:48
 */
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int minBuy = Integer.MAX_VALUE;
        for (int price : prices){
            if (price < minBuy){
                minBuy = price;
            } else {
                maxValue = Math.max(maxValue, price - minBuy);
            }
        }
        return maxValue;
    }
}
