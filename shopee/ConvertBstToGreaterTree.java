package shopee;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/24 20:41
 */
public class ConvertBstToGreaterTree {
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

    public TreeNode convertBST(TreeNode root) {
        antiInorder(root);
        return root;
    }
    int lastCount = 0;
    public void antiInorder(TreeNode node){
        if (node == null){
            return ;
        }
        antiInorder(node.right);
        node.val += lastCount;
        lastCount = node.val;
        antiInorder(node.left);
    }
}
