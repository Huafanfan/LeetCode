package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/24 10:28
 */
public class UnivaluedBinaryTree0965 {
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
    int value = 100;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        if (value == 100){
            value = root.val;
        } else {
            if (value != root.val){
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
