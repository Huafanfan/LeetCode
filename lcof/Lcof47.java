package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/19 10:54
 */
public class Lcof47 {
    /**
     * 97.98%
     * 95.77%
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //int[][] dp = new int[m][n];
        //int[] dp = new int[n];
        //dp[0][0] = grid[0][0];
        //dp[0] = grid[0][0];
        //for (int i=1; i<m; i++){
        //    dp[i][0] = dp[i-1][0] + grid[i][0];
        //}
        for (int i=1; i<n; i++){
            //dp[0][i] = dp[0][i-1] + grid[0][i];
            //dp[i] = dp[i-1] + grid[0][i];
            grid[0][i] += grid[0][i-1];
        }
        for (int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
            //dp[0] += grid[i][0];
            for (int j=1; j<n; j++){
                //dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                //dp[j] = Math.max(dp[j], dp[j-1]) + grid[i][j];
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        //return dp[m-1][n-1];
        return grid[m-1][n-1];
    }
}
