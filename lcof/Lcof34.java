package lcof;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/17 15:02
 */
public class Lcof34 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 100.00%
     * 75.46%
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    public void dfs(TreeNode root, int count, int sum, List<Integer> path, List<List<Integer>> res){
        if (root != null){
            count += root.val;
            path.add(root.val);
            if (count == sum){
                if (root.right == null && root.left == null){
                    res.add(new ArrayList<>(path));
                }
            }
            dfs(root.left, count, sum, path, res);
            dfs(root.right, count, sum, path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(-6);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(-7);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.left = node6;
        Lcof34 lcof34 = new Lcof34();
        lcof34.pathSum(node1, 0);
    }
}
