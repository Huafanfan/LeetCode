package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, cur = 0, idx = nums.length - 1;
        for (int i : nums) {
            sum += i;
        }
        List<Integer> ans = new ArrayList<>();
        while (cur <= sum) {
            sum -= nums[idx];
            cur += nums[idx];
            ans.add(nums[idx--]);
        }
        return ans;
    }
}
