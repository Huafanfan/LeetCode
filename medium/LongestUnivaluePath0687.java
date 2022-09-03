package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/9/3 11:49 AM
 */
public class LongestUnivaluePath0687 {
    public class TreeNode {
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

    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    public int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int ans = 0;
        int cur = 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.left.val == root.val){
            ans = left + 1;
            cur += left + 1;
        }

        if (root.right != null && root.right.val == root.val){
            ans = Math.max(ans, right + 1);
            cur += right + 1;
        }

        maxLength = Math.max(maxLength, cur);
        return ans;
    }
}
