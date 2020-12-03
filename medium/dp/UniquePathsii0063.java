package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/3 11:18
 */
public class UniquePathsii0063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length ==0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i=1; i<m; i++){
            if (obstacleGrid[i][0]!=1&&dp[i-1][0]==1) {
                dp[i][0] = 1;
            }
        }
        for (int i=1; i<n; i++){
            if (obstacleGrid[0][i]!=1&&dp[0][i-1]==1) {
                dp[0][i] = 1;
            }
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePathsii0063 uniquePathsii0063 = new UniquePathsii0063();
        int[][] ob = new int[][]{{0,0,},{1,0},{0,0}};
        System.out.println(uniquePathsii0063.uniquePathsWithObstacles2(ob));
    }
}
