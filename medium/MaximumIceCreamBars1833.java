package medium;

import java.util.Arrays;

public class MaximumIceCreamBars1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs){
            if (cost <= coins){
                res++;
                coins -= cost;
            }
            else {
                break;
            }
        }
        return res;
    }

    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 超时
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream3(int[] costs, int coins) {
        int[] dp = new int[coins + 1];
        for (int cost : costs){
            for (int j=coins; j>=cost; j--){
                dp[j] = Math.max(dp[j], dp[j - cost] + 1);
            }
        }
        return dp[coins];
    }
}
