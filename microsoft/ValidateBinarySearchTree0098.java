package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 19:47
 */
public class ValidateBinarySearchTree0098 {
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
    boolean res = true;
    TreeNode lastNode = null;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode node){
        if (node == null){
            return;
        }
        inorder(node.left);
        if (lastNode != null){
            res &= lastNode.val < node.val;
        }
        else {
            lastNode = node;
        }
        inorder(node.right);
    }
}
