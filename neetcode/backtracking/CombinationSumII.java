package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backTrace(candidates, target, sum+candidates[i], i + 1, list);
            list.remove(list.size()-1);
        }
    }

}
