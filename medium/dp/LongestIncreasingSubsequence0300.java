package medium.dp;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/4 14:08
 */
public class LongestIncreasingSubsequence0300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int result = 0;
        for (int i=1; i<n; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i=1; i<n; i++) {
            if (nums[i] > d[len]){
                d[++len] = nums[i];
            }
            else {
                int l=1, r=len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence0300 longestIncreasingSubsequence0300 = new LongestIncreasingSubsequence0300();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence0300.lengthOfLIS(nums));
    }
}
