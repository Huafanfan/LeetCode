package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/11/24 09:31
 */
public class CountCompleteTreeNodes0222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null){
            left = countNodes(root.left);
        }
        if (root.right != null){
            right = countNodes(root.right);
        }
        return 1 + left + right;
    }
}
