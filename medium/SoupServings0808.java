package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/11/21 15:47
 */
public class SoupServings0808 {
    public double soupServings(int n) {
        if(n > 4450) {
            return 1;
        }

        n = (int) Math.ceil(n / 25d);

        double[][] dp = new double[n + 1][n + 1];

        dp[n][n] = 1;

        double temp;

        for(int i = n; i > 0; i--) {
            for(int j = n; j > 0; j--) {
                if(dp[i][j] == 0) {
                    continue;
                }

                temp = 0.25 * dp[i][j];

                dp[Math.max(0, i - 4)][j] += temp;
                dp[Math.max(0, i - 3)][Math.max(0, j - 1)] += temp;
                dp[Math.max(0, i - 2)][Math.max(0, j - 2)] += temp;
                dp[Math.max(0, i - 1)][Math.max(0, j - 3)] += temp;
            }
        }

        dp[0][0] /= 2;

        for(int i = 1; i <= n; i++) {
            dp[0][0] += dp[0][i];
        }

        return dp[0][0];
    }
}
