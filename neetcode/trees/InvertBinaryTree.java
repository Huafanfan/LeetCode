package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/23 11:57
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp  = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
