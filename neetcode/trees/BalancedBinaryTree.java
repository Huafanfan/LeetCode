package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/24 11:21
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) > -1;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        if (Math.abs(leftMax - rightMax) > 1 || leftMax == -1 || rightMax == -1){
            return -1;
        }
        return 1 + Math.max(leftMax, rightMax);
    }
}
