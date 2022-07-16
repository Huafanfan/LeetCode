package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/16 20:53
 */
public class Subsets {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
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
        backTrace(nums, index+1, list);
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(s.subsets(nums));
    }
}
