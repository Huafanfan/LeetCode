package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/10 14:06
 */
public class Combine0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k<=0||n<k){
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,result);
        return result;
    }
    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result){
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        // 剪枝
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
        //for (int i=begin; i<=n; i++){
        //    path.addLast(i);
        //    dfs(n, k, i+1, path, result);
        //    path.removeLast();
        //}
    }

    /**
     * 考虑选还是不选
     * @param begin
     * @param n
     * @param k
     * @param path
     * @param res
     */
    private void dfs2(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 基础版本的递归终止条件：if (begin == n + 1) {
        if (begin > n - k + 1) {
            return;
        }
        // 不选当前考虑的数 begin，直接递归到下一层
        dfs2(begin + 1, n, k, path, res);

        // 选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        path.addLast(begin);
        dfs2(begin + 1, n, k - 1, path, res);
        // 深度优先遍历有回头的过程，因此需要撤销选择
        path.removeLast();
    }
}
