package medium;

public class OutOfBoundaryPaths0576 {
    int MOD = 1000000007;
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        return dfs(m, n, startRow, startColumn, maxMove);
    }

    int dfs(int m, int n, int i, int j, int k){
        if(k < 0){
            return 0;
        }
        if(i > k && m - i > k && j > k && n - j > k){
            return 0;  // 剪枝
        }
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 1;
        }
        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        for(int a = 0; a < 4; a++){
            int x = i + dx[a];
            int y = j + dy[a];
            dp[i][j][k] = (dp[i][j][k] + dfs(m, n, x, y, k - 1)) % MOD;
        }
        return dp[i][j][k];
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths0576 outOfBoundaryPaths0576 = new OutOfBoundaryPaths0576();
        System.out.println(outOfBoundaryPaths0576.findPaths(2, 2, 2, 0, 0));
    }
}
