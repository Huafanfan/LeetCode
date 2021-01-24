package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/24 18:07
 */
public class LongestContinuousIncreasingSubsequence0647 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
