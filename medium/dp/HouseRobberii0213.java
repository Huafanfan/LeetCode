package medium.dp;

import java.util.Arrays;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/4 11:58
 */
public class HouseRobberii0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i=2; i<n-1; i++) {
            if (i==2){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
            }
            else {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
            }
        }
        dp2[n-1] = Math.max(dp2[n-2], dp2[n-3] + nums[n-1]);
        return Math.max(dp1[n-2], dp2[n-1]);
    }

    public int rob2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
