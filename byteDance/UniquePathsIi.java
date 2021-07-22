package byteDance;

public class UniquePathsIi {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}
