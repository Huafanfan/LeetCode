package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/8 11:26
 */
public class LongestTurbulentSubarray0987 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return n;
        }
        int res = 1;
        int left = 0;
        int right = 1;
        boolean pre = false;
        while (right < n){
            boolean cur = arr[right] > arr[right - 1];
            if (right == 1 || cur == pre){
                left = right - 1;
            }
            if (arr[right] == arr[right - 1]){
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
            pre = cur;
        }
        return res;
    }

    public int maxTurbulenceSizeDp(int[] arr) {
        int n = arr.length;
        int ret = 1;
        //int[][] dp = new int[n][2];
        int[] dp = new int[2];
        //dp[0][0] = dp[0][1] = 1;
        dp[0] = dp[1] = 1;
        for (int i=1; i<n; i++){
            //dp[i][0] = dp[i][1] = 1;
            if (arr[i] > arr[i-1]){
                //dp[i][0] = dp[i-1][1] + 1;
                dp[0] = dp[1] + 1;
                dp[1] = 1;
            }
            else if (arr[i] < arr[i-1]){
                //dp[i][1] = dp[i-1][0] + 1;
                dp[1] = dp[0] + 1;
                dp[0] = 1;
            }
            else {
                dp[0] = 1;
                dp[1] = 1;
            }
            ret = Math.max(ret, dp[0]);
            ret = Math.max(ret, dp[1]);
        }
        //for (int i = 0; i < n; i++) {
        //    ret = Math.max(ret, dp[i][0]);
        //    ret = Math.max(ret, dp[i][1]);
        //}
        return ret;
    }
}
