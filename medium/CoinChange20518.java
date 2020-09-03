package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/3 11:04
 */
public class CoinChange20518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int x=coin; x<=amount; x++){
                dp[x] += dp[x-coin];
            }
        }
        return dp[amount];
    }
}
