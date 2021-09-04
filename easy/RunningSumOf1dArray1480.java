package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/9/4 11:11
 */
public class RunningSumOf1dArray1480 {
    public int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
