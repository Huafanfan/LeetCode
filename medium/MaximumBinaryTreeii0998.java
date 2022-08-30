package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/8/30 10:47 PM
 */
public class MaximumBinaryTreeii0998 {
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode prev = null, cur = root;
        while (cur != null && cur.val > val) {
            prev = cur; cur = cur.right;
        }
        if (prev == null) {
            node.left = cur;
            return node;
        } else {
            prev.right = node;
            node.left = cur;
            return root;
        }
    }
}
