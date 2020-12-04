package medium.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/10 12:18
 */
public class MaximumProductSubarray0152 {
    public int maxProduct(int[] nums) {
        List<Integer> maxF = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> minF = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i=1; i<nums.length; i++){
            //这里就是max(Fmax(i-1)*ai,Fmin(i-1)*ai,ai);
            maxF.add(i,Math.max(maxF.get(i-1)*nums[i],Math.max(nums[i],minF.get(i-1)*nums[i])));
            //这里就是min(Fmax(i-1)*ai,Fmin(i-1)*ai,ai);
            minF.add(i,Math.min(minF.get(i-1)*nums[i],Math.min(nums[i],maxF.get(i-1)*nums[i])));
        }
        return Collections.max(maxF);
    }

    public int maxProduct2(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        for (int i=1; i<nums.length; i++){
            int mx = maxF, mn = minF;
            maxF = Math.max(mx*nums[i],Math.max(nums[i],mn*nums[i]));
            minF = Math.min(mn*nums[i],Math.min(nums[i],mx*nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public int maxProduct3(int[] nums) {
        int[][] dp = new int[nums.length+1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = nums[0];
        for (int i=0; i<nums.length; i++){
            dp[i+1][0] = Math.max(nums[i],Math.max(dp[i][0]*nums[i], dp[i][1]*nums[i]));
            dp[i+1][1] = Math.min(nums[i],Math.min(dp[i][0]*nums[i], dp[i][1]*nums[i]));
            max = Math.max(max,Math.max(dp[i+1][0], dp[i+1][1]));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray0152 maximumProductSubarray0152 = new MaximumProductSubarray0152();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maximumProductSubarray0152.maxProduct3(nums));
    }

}
