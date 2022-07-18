package neetcode.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/18 09:58
 */
public class SubsetsII {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backTrace(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    public void backTrace(int[] nums, int index, List<Integer> list){
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backTrace(nums, index+1, list);
        list.remove(list.size()-1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        backTrace(nums, index+1, list);
    }
}
