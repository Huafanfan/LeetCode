package hard;

import java.util.HashMap;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/29 10:25
 */
public class NumberOfSubmatricesThatSumToTarget1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++){
            int[] sum = new int[n];
            for (int j=i; j<m; j++){
                for (int k=0; k<n; k++){
                    sum[k] += matrix[j][k];
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int numSubmatrixSumTarget2(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int p = 1; p <= i; p++) {
                    for (int q = 1; q <= j; q++) {
                        if (sum[i][j] - sum[p - 1][j] - sum[i][q - 1] + sum[p - 1][q - 1] == t) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
