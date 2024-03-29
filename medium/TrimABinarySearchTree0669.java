package medium;

/**
 * @author yifan.zhangyf
 * @date 2022/9/10 8:12 PM
 */
public class TrimABinarySearchTree0669 {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        if (root.val > high){
            return trimBST(root.left, low, high);
        }
        else if (root.val < low){
            return trimBST(root.right, low, high);
        }
        else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
