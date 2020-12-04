package medium.dp;

import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/4 10:37
 */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        for (int i=length-2; i>=0; i--) {
            for (int j=0; j<triangle.get(i).size(); j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<length; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j=1; j<i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j-1], dp[i-1][j]);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int minPath = dp[length-1][0];
        for (int i=1; i<length; i++){
            minPath = Math.min(minPath, dp[length-1][i]);
        }
        return minPath;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        }
        return minTotal;
    }

    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            for (int j = i-1; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int minTotal = dp[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }
}
