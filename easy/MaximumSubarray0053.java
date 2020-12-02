package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/2 15:18
 */
public class MaximumSubarray0053 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            //if (dp[i-1] <= 0) {
            //    dp[i] = nums[i];
            //}
            //else {
            //    dp[i] = dp[i-1] + nums[i];
            //}
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int maxSum = nums[0], res = 0;
        for (int num : nums) {
            res += num;
            if (res > maxSum) {
                maxSum = res;
            }
            if (res < 0) {
                res = 0;
            }
        }
        return maxSum;
    }
}
