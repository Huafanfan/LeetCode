package hard;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/17 16:26
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps1269 {
    public int numWays(int steps, int arrLen) {
        int maxLength = Math.min(steps / 2, arrLen - 1);
        //dp[i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数
        //int[][] dp = new int[steps + 1][maxLength + 1];
        //dp[0][0] = 1;
        int[] dp = new int[maxLength + 1];
        dp[0] = 1;
        for (int i=1; i<=steps; i++){
            int max = Math.min(i, maxLength);
            int[] nextDp = new int[maxLength + 1];
            for (int j=0; j<=max; j++){
                nextDp[j] = dp[j];
                //dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    //dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000007;
                    nextDp[j] = (nextDp[j] + dp[j - 1]) % 1000000007;
                }
                if (j + 1 <= maxLength) {
                    //dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000007;
                    nextDp[j] = (nextDp[j] + dp[j + 1]) % 1000000007;
                }
            }
            dp = nextDp;
        }
        //return dp[steps][0];
        return dp[0];
    }
}
