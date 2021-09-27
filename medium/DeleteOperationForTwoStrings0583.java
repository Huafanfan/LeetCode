package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/27 16:11
 */
public class DeleteOperationForTwoStrings0583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j] 表示 text[0:i] 和 text2[0:j] 的最长公共子序列的长度。
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++){
            char c1 = word1.charAt(i-1);
            for (int j=1; j<=n; j++){
                char c2 = word2.charAt(j-1);
                if (c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
