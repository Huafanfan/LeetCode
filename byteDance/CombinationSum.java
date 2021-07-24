package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 15:21
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, new ArrayList<>(), res, 0, 0, target);
        return res;
    }

    public void dfs(int[] candidates, List<Integer> path, List<List<Integer>> res, int index, int curSum, int target){
        if (curSum == target){
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i<candidates.length; i++){
            if(curSum + candidates[i] > target){
                continue;
            }
            curSum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates, path, res, i, curSum, target);
            path.remove(path.size() - 1);
            curSum -= candidates[i];
        }
    }
}
