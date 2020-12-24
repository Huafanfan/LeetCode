package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 11:32
 */
public class Lcof68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val<p.val&&root.val< q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val>p.val&&root.val> q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val < p.val && root.val < q.val)
            {
                root = root.right;
            } else if(root.val > p.val && root.val > q.val)
            {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
