package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/23 12:20
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int deep){
        if (node == null){
            return deep;
        }
        int left = dfs(node.left, deep + 1);
        int right = dfs(node.right, deep + 1);
        return Math.max(left, right);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }
}
