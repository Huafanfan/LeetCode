package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/5/5 16:55
 */
public class DeleteAndEarn0740 {
    public int deleteAndEarn(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] sum = new int[maxNum + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return rob(sum);
    }

    public int rob(int[] nums){
        int last = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length; i++){
            int tmp = cur;
            cur = Math.max(nums[i] + last, cur);
            last = tmp;
        }
        return cur;
    }
}
