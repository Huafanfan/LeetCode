package com.huafanfan.medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/6/3 16:04
 */
public class CombinationSum0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
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
            dfs(candidates, len, residue-candidates[i], i, path, res);
            path.removeLast();
        }
    }
}
