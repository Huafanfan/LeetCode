package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/3/8 12:07
 */
public class PalindromePartitioningIi0131 {
    int res = Integer.MAX_VALUE;
    public int minCut(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i=0; i<len; i++){
            for (int j=0; j<=i; j++){
                if (chars[j] == chars[i] && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                }
            }
        }
        dfs(s, 0, len, dp, new ArrayDeque<>());
        return res;
    }

    public void dfs(String s, int start, int len, boolean[][] dp, Deque<String> path){
        if (start == len){
            if (path.size() - 1 < res){
                res = path.size() - 1;
                return;
            }
        }
        for (int i = start; i < len; i++){
            if (!dp[start][i]){
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            dfs(s, i + 1, len, dp, path);
            path.removeLast();
        }
    }

    public int minCut2(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningIi0131 palindromePartitioningIi0131 = new PalindromePartitioningIi0131();
        System.out.println(palindromePartitioningIi0131.minCut("abbab"));
    }
}
