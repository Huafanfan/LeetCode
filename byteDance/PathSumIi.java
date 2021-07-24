package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 14:39
 */
public class PathSumIi {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res, 0, targetSum);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> path, List<List<Integer>> res, int curSum, int targetSum){
        if (root == null){
            return;
        }
        path.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == targetSum){
            res.add(new ArrayList<>(path));
        }
        else {
            if (root.left != null){
                dfs(root.left, path, res, curSum, targetSum);
            }
            if (root.right != null){
                dfs(root.right, path, res, curSum, targetSum);
            }
        }
        path.remove(path.size() - 1);
    }
}
