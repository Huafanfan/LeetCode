package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/30 09:09
 */
public class InsertIntoaBinarySearchTree0701 {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true) {
            if (val > curr.val){
                if (curr.right != null){
                    curr = curr.right;
                }
                else {
                    curr.right = new TreeNode(val);
                    return root;
                }
            }
            else {
                if (curr.left != null){
                    curr = curr.left;
                }
                else {
                    curr.left = new TreeNode(val);
                    return root;
                }
            }
        }
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST1(root.left, val);
        } else {
            root.right = insertIntoBST1(root.right, val);
        }
        return root;
    }
}
