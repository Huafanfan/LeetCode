package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/4 11:24
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean dfs(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        //if (node.left != null && node.left.val >= node.val){
        //    return false;
        //}
        //if (node.right != null && node.right.val <= node.val){
        //    return false;
        //}
        //return dfs(node.left, min, (long) node.val) && dfs(node.right, (long) node.val, max);
    }
}
