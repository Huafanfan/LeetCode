package easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/28 12:13
 */
public class SymmetricTree101 {
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right , right.left);
    }
}
