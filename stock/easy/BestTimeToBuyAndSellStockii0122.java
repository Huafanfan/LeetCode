package stock.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/4/30 01:31
 */
public class BestTimeToBuyAndSellStockii0122 {
    public static void main(String[] args){
        int[] a = new int[] {7,1,5,3,6,4};
        int[] b = new int[] {1,2,3,4,5};
        int[] c = new int[] {7,6,4,3,1};
        System.out.println(maxProfitForce(a));
        System.out.println(maxProfitForce(b));
        System.out.println(maxProfitForce(c));
        System.out.println();
        System.out.println(maxProfitPeakValley(a));
        System.out.println(maxProfitPeakValley(b));
        System.out.println(maxProfitPeakValley(c));
        System.out.println();
        System.out.println(maxProfitOnce(a));
        System.out.println(maxProfitOnce(b));
        System.out.println(maxProfitOnce(c));
    }

    /**
     * 暴力法（超时）
     * 时间复杂度：O(n^n)，调用递归函数 n^n次。
     * 空间复杂度：O(n)，递归的深度为 n。
     */
    public static int maxProfitForce(int[] prices) {
        return calculate(prices, 0);
    }
    public static int calculate(int[] prices,int s) {
        if (s>prices.length){
            return 0;
        }
        int max=0;
        for (int i=s; i<prices.length; i++){
            int maxprofit=0;
            for (int j=i+1; j<prices.length; j++){
                if (prices[i]<prices[j]){
                    int profit = calculate(prices, j+1)+prices[j]-prices[i];
                    if (profit>maxprofit){
                        maxprofit = profit;
                    }
                }
            }
            if (maxprofit>max){
                max = maxprofit;
            }
        }
        return max;
    }

    /**
     * 峰谷法
     * 时间复杂度：O(n)。遍历一次。
     * 空间复杂度：O(1)。需要常量的空间。
     */
    public static int maxProfitPeakValley(int[] prices) {
        int i=0;
        int valley=prices[0];
        int peak=prices[0];
        int maxprofit=0;
        while (i<prices.length-1){
            while (i<prices.length-1&&prices[i]>=prices[i+1]){
                i++;
            }
            valley=prices[i];
            while (i<prices.length-1&&prices[i]<=prices[i+1]){
                i++;
            }
            peak=prices[i];
            maxprofit+=peak-valley;
        }
        return maxprofit;
    }

    /**
     * 一次遍历
     * 时间复杂度：O(n)，遍历一次。
     * 空间复杂度：O(1)，需要常量的空间。
     */
    public static int maxProfitOnce(int[] prices) {
        int maxprofit = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i]>prices[i-1]){
                maxprofit+=prices[i]-prices[i-1];
            }
        }
        return maxprofit;
    }

    public static int maxProfitDp(int[] prices) {
        int n = prices.length;
        //int[][] dp = new int[n][2];
        //dp[0][0] = 0;
        //dp[0][1] = -prices[0];
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i=1; i<n; i++){
            //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        //return dp[n-1][0];
        return dp0;
    }
}
