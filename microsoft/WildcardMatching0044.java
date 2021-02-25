package microsoft;

public class WildcardMatching0044 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i=1; i<=n; i++){
            if (p.charAt(i-1) == '*'){
                dp[0][i] = true;
            }
            else {
                break;
            }
        }
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (p.charAt(j - 1) == '*') {
                    //如果 pj是星号，那么同样对 si没有任何要求，但是星号可以匹配零或任意多个小写字母，因此状态转移方程分为两种情况，即使用或不使用这个星号：
                    //dp[i][j]=dp[i][j−1]∨dp[i−1][j]
                    //其中 ∨ 表示逻辑或运算。如果我们不使用这个星号，那么就会从 dp[i][j−1] 转移而来；如果我们使用这个星号，那么就会从 dp[i−1][j] 转移而来。
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
