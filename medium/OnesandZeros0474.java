package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/2 10:28
 */
public class OnesandZeros0474 {
    public static void main(String[] args) {
        OnesandZeros0474 onesandZeros0474 = new OnesandZeros0474();
        String[] strs = new String[]{"10", "0", "1"};
        System.out.println(onesandZeros0474.findMaxForm(strs,1,1));
    }
    public int findMaxFormPro(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int M = m+1;
        int N = n+1;
        // dp[插入/不插入第i个字符串][m个1][n个0] 组合最多的字符串数量
        int[][][] dp = new int[strs.length+1][M][N];
        for (int i=1;i<strs.length+1;i++) {
            String str = strs[i-1];
            int[] count = countzeroesones(str);
            int zeroCount = count[0];
            int oneCount = count[1];

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(j>=zeroCount&&k>=oneCount) {
                        dp[i][j][k] = Math.max(dp[i-1][j-zeroCount][k-oneCount]+1,dp[i][j][k]);
                    }
                    dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i][j][k]);
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
