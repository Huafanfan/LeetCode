package easy;

public class MinimumDistanceBetweenBstNodes0783 {
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

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        preorderTraversal(root);
        return min;
    }

    public void preorderTraversal(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        preorderTraversal(treeNode.left);
        if (pre != null){
            min = Math.min(treeNode.val - pre.val, min);
        }
        pre = treeNode;
        preorderTraversal(treeNode.right);
    }
}
