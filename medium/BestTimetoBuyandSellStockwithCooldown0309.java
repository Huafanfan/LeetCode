package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/21 11:47
 */
public class BestTimetoBuyandSellStockwithCooldown0309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        // f[i]表示第i天结束后的累计最大收益
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益

        //f[0][2]的状态就是第0天不买入，很容易理解。而对这句话，我的想法如下:
        //简单理解： 两种都是不持有，自然收益就是0了
        //更具体理解：f[0][1] 其实可以存在，可以理解为当天买入卖出，收益自然也是0。而且会导致下一天"冷冻期”,显然是只有弊端。
        //结合代码理解： f[0][1]只影响f[1][2],而f[1][2]又是由f[0][1]和f[0][2]共同决定的，而f[0][2]如上文所说，肯定就是0。 因此f[1][2]=Math.max(f[0][1], f[0][2]); ，只要f[0][1]<=0 都是不会造成影响的。
        //因此我认为 f[0][1] = Integer.MIN_VALUE; 更容易理解，表示只会带来负收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        //不与f[n -1][0]比较的原因是最后一天手里还持有股票没有意义
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
    public int maxProfitPro(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = Integer.MIN_VALUE;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }
}
