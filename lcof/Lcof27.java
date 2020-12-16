package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 16:03
 */
public class Lcof27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 100.00%
     * 96.30%
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        else {
            TreeNode treeNode = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(treeNode);
            return root;
        }
    }
}
