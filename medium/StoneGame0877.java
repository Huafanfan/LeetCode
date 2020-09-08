package medium;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/8 10:49
 */
public class StoneGame0877 {
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        //dp[i][j] 表示当剩下的石子堆为下标 i 到下标 j 时，当前玩家与另一个玩家的石子数量之差的最大值，也就是最大利润
        int[][] dp = new int[length][length];
        for (int i=0; i<length; i++){
            dp[i][i] = piles[i];
        }
        for (int i=length-2; i>=0; i--){
            for (int j=i+1; j<length; j++){
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public boolean stoneGamePro(int[] piles) {
        int length = piles.length;
        int[] dp = new int[length];
        System.arraycopy(piles, 0, dp, 0, length);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] > 0;
    }

    public boolean stoneGameRecursion(int[] piles) {
        int len = piles.length;
        //memo[i][j] 石头堆i到j能获得最大利润
        int[][] memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            // 由于是相对分数，有可能是在负值里面选较大者，因此初始化的时候不能为 0
            Arrays.fill(memo[i], Integer.MIN_VALUE);
            memo[i][i] = piles[i];
        }
        return stoneGame(piles, 0, len - 1, memo) > 0;
    }


    /**
     * 计算子区间 [left, right] 里先手能够得到的分数
     *
     * @param piles
     * @param left
     * @param right
     * @return
     */
    private int stoneGame(int[] piles, int left, int right, int[][] memo) {
        if (left == right) {
            return piles[left];
        }
        //计算过就不需要再计算了
        if (memo[left][right] != Integer.MIN_VALUE) {
            return memo[left][right];
        }

        int chooseLeft = piles[left] - stoneGame(piles, left + 1, right, memo);
        int chooseRight = piles[right] - stoneGame(piles, left, right - 1, memo);
        int res = Math.max(chooseLeft, chooseRight);
        memo[left][right] = res;
        return res;
    }

}
