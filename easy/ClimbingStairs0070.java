package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/2 15:40
 */
public class ClimbingStairs0070 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
