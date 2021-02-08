package microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/7 16:55
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
public class TwoSum0001 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
