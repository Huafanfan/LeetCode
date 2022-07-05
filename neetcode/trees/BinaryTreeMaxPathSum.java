package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/5 10:04
 */
public class BinaryTreeMaxPathSum {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxValue = Math.max(maxValue, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
