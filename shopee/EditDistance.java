package shopee;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 20:06
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0){
            return n + m;
        }

        int[][] dp = new int[n+1][m+1];

        for (int i=0; i<n+1; i++){
            dp[i][0] = i;
        }

        for (int j=0; j<m+1; j++){
            dp[0][j] = j;
        }

        for (int i=1; i<n+1; i++){
            for (int j=1; j<m+1; j++){
                int a = dp[i-1][j] + 1;
                int b = dp[i][j-1] + 1;
                int c = dp[i-1][j-1];
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(a, b), c);
                }
                else {
                    dp[i][j] = Math.min(Math.min(a, b), c + 1);
                }
            }
        }
        return dp[n][m];
    }
}
