package medium.dp;

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
