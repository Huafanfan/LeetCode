package hard;

import java.util.Arrays;

public class MinimumCostToReachDestinationInTime1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        final int INF = Integer.MAX_VALUE / 2;
        // f[t][i] 表示使用恰好 t 分钟到达城市 i 需要的最少通行费总和
        int[][] f = new int[maxTime + 1][n];
        for (int i = 0; i <= maxTime; ++i) {
            Arrays.fill(f[i], INF);
        }
        f[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; ++t) {
            for (int[] edge : edges) {
                int i = edge[0], j = edge[1], cost = edge[2];
                if (cost <= t) {
                    f[t][i] = Math.min(f[t][i], f[t - cost][j] + passingFees[i]);
                    f[t][j] = Math.min(f[t][j], f[t - cost][i] + passingFees[j]);
                }
            }
        }
        int ans = INF;
        for (int t = 1; t <= maxTime; ++t) {
            ans = Math.min(ans, f[t][n-1]);
        }
        return ans == INF ? -1 : ans;
    }
}
