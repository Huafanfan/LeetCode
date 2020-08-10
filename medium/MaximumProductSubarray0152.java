package medium;

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
}
