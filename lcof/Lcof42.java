package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/18 16:25
 */
public class Lcof42 {
    /**
     * 98.65%
     * 67.48%
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length<1){
            return Integer.MIN_VALUE;
        }
        int dp = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; i++){
            if (dp < 0){
                dp = nums[i];
            }
            else {
                dp = dp + nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
