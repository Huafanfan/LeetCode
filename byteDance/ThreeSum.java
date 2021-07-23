package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/23 11:38
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length - 2; i++){
            if (nums[i] > 0){
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            int target = -nums[i];
            while (left < right){
                if (nums[left] + nums[right] == target){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left++]);
                    cur.add(nums[right--]);
                    res.add(cur);
                    while (left < right && nums[left - 1] == nums[left]){
                        left++;
                    }
                    while (right > left && (nums[right + 1] == nums[right])){
                        right--;
                    }
                }
                else if (nums[left] + nums[right] < target){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
}
