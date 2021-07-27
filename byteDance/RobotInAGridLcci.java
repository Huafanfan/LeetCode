package byteDance;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGridLcci {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return res;
        }
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (obstacleGrid[i][j] == 0){
                    if (i > 0){
                        dp[i][j] |= dp[i-1][j];
                    }
                    if (j > 0){
                        dp[i][j] |= dp[i][j-1];
                    }
                }
            }
        }
        if (!dp[m-1][n-1])
        {
            return res;
        }

        int i = m-1;
        int j = n-1;
        while (i >= 0 && j >= 0){
            List<Integer> point = new ArrayList<>();
            point.add(i);
            point.add(j);
            res.add(0, point);
            if (i > 0  && dp[i-1][j]){
                i--;
            }else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RobotInAGridLcci robotInAGridLcci = new RobotInAGridLcci();
        int[][] obstacleGrid = new int[][]{{0,0}};
        System.out.println(robotInAGridLcci.pathWithObstacles(obstacleGrid));
    }
}
