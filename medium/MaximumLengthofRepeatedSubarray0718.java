package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/6 11:17
 */
public class MaximumLengthofRepeatedSubarray0718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i=n-1; i>=0; i--){
            for (int j=m-1; j>=0; j--){
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
