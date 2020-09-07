package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/6 11:17
 */
public class MaximumLengthofRepeatedSubarray0718 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        MaximumLengthofRepeatedSubarray0718 maximumLengthofRepeatedSubarray0718 = new MaximumLengthofRepeatedSubarray0718();
        System.out.println(maximumLengthofRepeatedSubarray0718.findLength(A,B));
    }
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        //从后往前遍历和从前往后遍历
        //for (int i=n-1; i>=0; i--){
        //    for (int j=m-1; j>=0; j--){
        //        dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
        //        ans = Math.max(ans, dp[i][j]);
        //    }
        //}
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                dp[i][j] = A[i-1] == B[j-1] ? dp[i - 1][j - 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int findLengthWindows(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }
    public int findLengthWindows2(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }
    public int findMax(int[] A, int[] B){
        int max = 0;
        int an = A.length;
        int bn = B.length;
        for (int i=1; i<=an; i++){
            max = Math.max(max,maxLength(A,B,0,bn-i,i));
        }
        for (int i=bn-an; i>0; i--){
            max = Math.max(max,maxLength(A,B,0,i,an));
        }
        for (int i=0; i<an; i++){
            max = Math.max(max,maxLength(A,B,i,0,an-i));
        }
        return max;
    }
}
