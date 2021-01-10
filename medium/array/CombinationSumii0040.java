package medium.array;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/6/3 16:32
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumii0040 {
    //public List<List<Integer>> combinationSum21(int[] candidates, int target) {
    //    Set<List<Integer>> res = new HashSet<>();
    //    int len = candidates.length;
    //    Arrays.sort(candidates);
    //    dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
    //    return new ArrayList<>(res);
    //}
    //void dfs(int[] candidates, int len, int residue, int start, Deque<Integer> path, Set<List<Integer>> res){
    //    if (residue==0){
    //        res.add(new ArrayList<>(path));
    //        return;
    //    }
    //    for (int i=start; i<len ;i++){
    //        if (residue-candidates[i]<0){
    //            break;
    //        }
    //        path.addLast(candidates[i]);
    //        dfs(candidates, len, residue-candidates[i], i+1, path, res);
    //        path.removeLast();
    //    }
    //}


    /**
     * @param candidates 候选数组
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int residue, List<Integer> path, List<List<Integer>> res) {
        if (residue < 0){
            return;
        }
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            // 小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //这个避免重复当思想是在是太重要了。
            //这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
            //         1
            //        / \
            //       2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
            //      /     \
            //     5       5
            //例2
            //        1
            //       /
            //      2       这种情况确是允许的
            //     /
            //    2
            //为何会有这种神奇的效果呢？
            //首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
            //可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
            //因为当第二个2出现的时候，他就和前一个2相同了。
            //
            //那么如何保留例2呢？
            //那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
            //例2的两个2是处在不同层级上的。
            //在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
            //必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
            //第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.

            path.add(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res);

            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);

        List<Integer> path = new ArrayList<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
}
