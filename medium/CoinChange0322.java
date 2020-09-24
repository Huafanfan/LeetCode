package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/21 14:30
 */
public class CoinChange0322 {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5,10};
        int amount = 8;
        CoinChange0322 coinChange0322 = new CoinChange0322();
        System.out.println(coinChange0322.coinChangeDPFromTopToLast(coins,amount));
    }
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }
    public int coinChange(int idxCoin, int[] coins, int amount){
        if (amount==0){
            return 0;
        }
        if (idxCoin < coins.length&&amount > 0){
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x=0; x<=maxVal; x++){
                if (amount>= x*coins[idxCoin]){
                    int res = coinChange(idxCoin+1, coins, amount - x*coins[idxCoin]);
                    if (res != -1){
                        minCost = Math.min(minCost,res+x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

    public int coinChangeDPFromTopToLast(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        //当前剩余金额的解
        if (count[rem] != 0) {
            return count[rem];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        // count[rem]存储着给定金额amount的解
        // 若为Integer.MAX_VALUE则该情况无解
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }

    public int coinChangeDPFromLastToTop(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
