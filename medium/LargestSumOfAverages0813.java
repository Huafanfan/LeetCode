package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/11/28 22:56
 */
public class LargestSumOfAverages0813 {
    public double largestSumOfAverages(int[] nums, int m) {
        int n = nums.length;
        double[] sum = new double[n + 10];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        // f[i][j] 为考虑将前 i 个元素划分成 j 份的最大平均和
        double[][] f = new double[n + 10][m + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                if (j == 1) {
                    f[i][1] = sum[i] / i;
                } else {
                    for (int k = 2; k <= i; k++) {
                        f[i][j] = Math.max(f[i][j], f[k - 1][j - 1] + (sum[i] - sum[k - 1]) / (i - k + 1));
                    }
                }
            }
        }
        return f[n][m];
    }
}
