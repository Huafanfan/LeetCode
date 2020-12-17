package stock.hard;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 11:02
 */
public class BestTimetoBuyandSellStockiv0188 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0 || k==0) {
            return 0;
        }
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for (int i=0; i<=k; i++){
            //第i天，第j轮，卖完后利益
            dp[0][i][0] = 0;
            //第i天，第j轮，买入后利益
            dp[0][i][1] = -prices[0];
        }
        for (int i=1; i<n; i++){
            dp[i][0][0] = dp[i-1][0][0];
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][0][0] - prices[i]);
            for (int j=1; j<k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0] - prices[i]);
            }
            dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[i]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i=0; i<=k; i++){
            maxProfit = Math.max(maxProfit, Math.max(dp[n-1][i][0], dp[n-1][i][1]));
        }
        return maxProfit;
    }
}
