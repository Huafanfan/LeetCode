package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 10:06
 */
public class BestTimetoBuyandSellStockiii0123 {
    /**
     * 超时
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        return dfs(prices, 0, 0, 0);
    }

    public int dfs(int[] prices, int index, int status, int k){
        if (index == prices.length || k == 2){
            return 0;
        }
        int unchanging = 0, buy = 0, sell = 0;
        unchanging = dfs(prices, index+1, status, k);
        if (status == 1){
            buy = dfs(prices, index+1, 0, k+1) + prices[index];
        }
        else {
            sell = dfs(prices, index+1, 1, k) - prices[index];
        }
        return Math.max(Math.max(unchanging, buy), sell);
    }

    /**
     * 5.14%
     * 5.02%
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        Map<Key,Integer> map = new HashMap<Key,Integer>();
        return dfs(map, prices, 0, 0, 0);
    }

    public int dfs(Map<Key,Integer> map, int[] prices, int index, int status, int k){
        Key key = new Key(index,status,k);
        if(map.containsKey(key)) {
            return map.get(key);
        }
        if (index == prices.length || k == 2){
            return 0;
        }
        int unchanging = 0, buy = 0, sell = 0;
        unchanging = dfs(map, prices, index+1, status, k);
        if (status == 1){
            buy = dfs(map, prices, index+1, 0, k+1) + prices[index];
        }
        else {
            sell = dfs(map, prices, index+1, 1, k) - prices[index];
        }
        map.put(key, Math.max(Math.max(unchanging, buy),sell));
        return map.get(key);
    }

    private class Key {
        final int index;
        final int status;
        final int k;
        Key(int index,int status,int k) {
            this.index = index;
            this.status = status;
            this.k = k;
        }
        //这里需要实现自定义的equals和hashCode函数
        @Override
        public int hashCode() {
            return this.index + this.status + this.k;
        }
        @Override
        public boolean equals(Object obj) {
            Key other = (Key)obj;
            return index == other.index && status == other.status && k == other.k;
        }
    }

    /**
     * 14.93%
     * 10.27%
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //定义三维数组，第i天、交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][3][2];
        //初始化第一天，这里的dp[0][2][1]可以不用管，后面也不会用到

        //表示第i天交易了0次时卖出后的累计最大利润
        dp[0][0][0] = 0;
        //表示第i天交易了0次时买入后的累计最大利润
        dp[0][0][1] = -prices[0];
        //表示第i天交易了1次时卖出后的累计最大利润
        dp[0][1][0] = 0;
        //表示第i天交易了1次时买入后的累计最大利润
        dp[0][1][1] = -prices[0];
        //表示第i天交易了2次时卖出后的累计最大利润
        dp[0][2][0] = 0;
        //表示第i天交易了2次时买入后的累计最大利润
        dp[0][2][1] = -prices[0];

        for(int i=1;i<n;++i) {
            //dp[i][0][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0][0] = dp[i-1][0][0];
            //处理第一次买入、第一次卖出
            dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][0][0]-prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][1]+prices[i]);
            //处理第二次买入、第二次卖出
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][1][0]-prices[i]);
            dp[i][2][0] = Math.max(dp[i-1][2][0],dp[i-1][1][1]+prices[i]);
        }
        //返回最大值
        int a = Math.max(dp[n-1][0][0],dp[n-1][0][1]);
        int b = Math.max(dp[n-1][1][0],dp[n-1][1][1]);
        return Math.max(Math.max(a,b),dp[n-1][2][0]);
    }


    /**
     * 87.06%
     * 66.80%
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //定义二维数组，5种状态
        //int[][] dp = new int[n][5];
        //初始化第一天的状态

        //初始化状态
        //dp[0][0] = 0;
        int dp0 = 0;
        //第一次买入
        //dp[0][1] = -prices[0];
        int dp1 = -prices[0];
        //第一次卖出
        //dp[0][2] = 0;
        int dp2 = 0;
        //第二次买入
        //dp[0][3] = -prices[0];
        int dp3 = -prices[0];
        //第二次卖出
        //dp[0][4] = 0;
        int dp4 = 0;
        for(int i=1;i<n;++i) {
            //dp[i][0]相当于初始状态，它只能从初始状态转换来
            //dp[i][0] = dp[i-1][0];
            //处理第一次买入、第一次卖出
            //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
            //dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            //处理第二次买入、第二次卖出
            //dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp3 = Math.max(dp3, dp2 - prices[i]);
            //dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        //返回最大值
        //return Math.max(Math.max( Math.max(dp[n-1][0],dp[n-1][1]),Math.max(dp[n-1][2],dp[n-1][3]) ),dp[n-1][4]);
        return Math.max(0, Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4)));
    }
}
