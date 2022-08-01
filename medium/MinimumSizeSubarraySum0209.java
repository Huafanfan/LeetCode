package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/17 14:43
 */
public class MinimumSizeSubarraySum0209 {
    public static void main(String[] args) {
        MinimumSizeSubarraySum0209 minimumSizeSubarraySum0209 = new MinimumSizeSubarraySum0209();
        int[] nums = new int[]{2,3,1,2,4,3};
        int s = 7;
        System.out.println(minimumSizeSubarraySum0209.minSubArrayLen(s,nums));
    }
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n<1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int slow = 0;
        int fast = 0;
        int sum = 0;
        while (fast<n){
            sum += nums[fast];
            while (sum>=s){
                ans = Math.min(ans, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
