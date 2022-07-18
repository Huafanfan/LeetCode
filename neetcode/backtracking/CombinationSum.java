package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/16 21:12
 */
public class CombinationSum {
    // 无重复
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }
    public void backTrace(int[] candidates, int target, int sum, int index, List<Integer> list){
        if (sum > target){
            return;
        }
        if (target == sum){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i<candidates.length; i++){
            list.add(candidates[i]);
            backTrace(candidates, target, sum+candidates[i], i, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] nums = new int[]{2,3,6,7};
        System.out.println(c.combinationSum(nums, 7));
    }
}
