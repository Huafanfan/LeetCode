package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/3 14:11
 */
public class MinimumPathSum0064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i=1; i<m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int j=1; j<n; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i=1; i<n; i++){
            dp[i] = grid[0][i] + dp[i-1];
        }
        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                if (j!=0){
                    dp[j] = grid[i][j] + Math.min(dp[j-1], dp[j]);
                }
                else {
                    dp[j] += grid[i][j];
                }
            }
        }
        return dp[n-1];
    }

    public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=1; i<n; i++){
            grid[0][i] += grid[0][i-1];
        }
        for (int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        MinimumPathSum0064 minimumPathSum0064 = new MinimumPathSum0064();
        int[][] ob = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minimumPathSum0064.minPathSum2(ob));
    }
}
