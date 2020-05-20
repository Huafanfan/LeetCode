package com.huafanfan;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/20 13:36
 */
public class HouseRobber0198 {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int prevMax=0;
        int currMax=0;
        for (int x:nums){
            int temp = currMax;
            currMax = Math.max(prevMax+x,currMax);
            prevMax = temp;
        }
        return currMax;
    }
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[ans.length - 1];
    }
}
