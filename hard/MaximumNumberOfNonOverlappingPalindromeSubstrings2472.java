package hard;

/**
 * @author yifan.zhangyf
 * @date 2022/11/16 22:30
 */
public class MaximumNumberOfNonOverlappingPalindromeSubstrings2472 {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] g = new boolean[n+1][n+1];
        for (int len = 1; len <= n; len++){
            for (int i=1; i+len-1 <= n; i++){
                int j = i+len-1;
                if (s.charAt(i-1) == s.charAt(j-1) && (len <= 2 || g[i+1][j-1])){
                    g[i][j] = true;
                }
            }
        }
        int[] f = new int[n+1];

        for (int i=1; i<=n; i++){
            f[i] = f[i-1];
            for (int j=i-k; j>=0; j--){
                if (g[j+1][i]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return f[n];
    }
}
