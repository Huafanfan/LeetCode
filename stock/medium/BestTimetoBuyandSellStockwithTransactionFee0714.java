package stock.medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/10 17:21
 */
public class BestTimetoBuyandSellStockwithTransactionFee0714 {
    public int maxProfit(int[] prices, int fee) {
        //int[] buy = new int[prices.length+1];
        //int[] sell = new int[prices.length+1];
        //buy[0] = -prices[0];
        //sell[0] = 0;
        int buy = -prices[0];
        int sell = 0;
        for (int i=0; i<prices.length; i++){
            buy = Math.max(sell - prices[i], buy);
            sell = Math.max(buy + prices[i] - fee, sell);
            /**
             *  i-1     i(price = 2, fee = 1)
             *  5       5
             *  6
             *  这种情况是i-1天的买入利益为5，卖出利益为6，此时i天的买入利益为i-1的值，对i天的卖不产生影响
             *
             *  i-1     i(price = 2, fee = 1)
             *  3       5
             *  6
             *  这种情况是i-1天的买入利益为3，卖出利益为6，此时i天的买入利益为5，sell[i-1] - price[i], i天的卖出利益为 Math.max(sell[i-1] - price[i] + prices[i] - fee, sell[i-1]) = sell[i-1]
             *  也就是说此时的buy[i]已经是大于buy[i-1]的值，但是最终的结果还是小于sell[i-1]，对结果不产生影响。
             */
            //buy[i+1] = Math.max(sell[i] - prices[i], buy[i]);
            //sell[i+1] = Math.max(buy[i] + prices[i] - fee, sell[i]);
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithTransactionFee0714 bestTimetoBuyandSellStockwithTransactionFee0714 = new BestTimetoBuyandSellStockwithTransactionFee0714();
        int[] prices = new int[]{1,5,2,8,4,9};
        System.out.println(bestTimetoBuyandSellStockwithTransactionFee0714.maxProfit(prices,2));
    }
}
