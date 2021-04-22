package hard;

public class MaxSumOfRectangleNoLargerThanK0363 {
    /**
     * dp
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        int[][][][] dp = new int[rows + 1][cols + 1][rows + 1][cols + 1]; // from (i1,j1) to (i2,j2)
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] - dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max) {
                            max = dp[i1][j1][i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * dp 减少空间
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                int[][] dp = new int[rows + 1][cols + 1]; // renew  // from (i1,j1) to (i2,j2)
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) {
                            max = dp[i2][j2];
                        }
                    }
                }
            }
        }
        return max;
    }

    /**
     * 滚动数组
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        // 枚举左边界
        for (int l = 0; l < cols; l++) {
            // 左边界改变才算区域的重新开始
            int[] rowSum = new int[rows];
            // 枚举右边界
            for (int r = l; r < cols; r++) {
                // 按每一行累计到 dp
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                // 求 rowSum 连续子数组的和
                // 和尽量大，但不大于k
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k){
                    return max;
                }
            }
        }
        return max;
    }

    /**
     * 这是暴力枚举，所有的子数组的和
     * @param arr
     * @param k
     * @return
     */
    private int dpmax(int[] arr, int k) {
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private int dpmax2(int[] arr, int k) {
        // 首先求最大子数组的和，思想也是dp，将负数排除
        int sum = arr[0];
        int max = sum;
        for (int i=1; i<arr.length; i++){
            if (sum > 0){
                sum += arr[i];
            }
            else {
                sum = arr[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        if (max <= k){
            return max;
        }

        // 如果求出来不满足小于等于k，则还是需要暴力
        max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }
}
