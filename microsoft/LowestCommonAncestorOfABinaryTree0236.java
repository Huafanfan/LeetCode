package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/16 20:16
 */
public class LowestCommonAncestorOfABinaryTree0236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);
        if ((lSon && rSon) || ((root.val == p.val || root.val == q.val) && (lSon || rSon))){
            ans = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }
}
