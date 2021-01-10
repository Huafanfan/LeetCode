package medium.array;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/6/3 16:04
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        //排序为了剪枝
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    void dfs(int[] candidates, int len, int residue, int start, Deque<Integer> path, List<List<Integer>> res){
        if (residue==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<len; i++){
            if(residue-candidates[i]<0){
                break;
            }
            path.addLast(candidates[i]);
            //这里的start==i,因为当前元素可以重复使用
            dfs(candidates, len, residue-candidates[i], i, path, res);
            path.removeLast();
        }
    }
}
