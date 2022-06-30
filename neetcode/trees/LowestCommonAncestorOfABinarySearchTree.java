package neetcode.trees;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/6/30 10:34
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
