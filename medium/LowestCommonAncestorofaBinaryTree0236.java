package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/20 11:08
 */
public class LowestCommonAncestorofaBinaryTree0236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode ans;

    public LowestCommonAncestorofaBinaryTree0236() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        //判断当前节点是否是p，q的父节点或者 是否是p或q，并且是p，q的父节点
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        //未找到父节点，就判断是否包含p或者q
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    public TreeNode lowestCommonAncestorOptimization(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p||root==q) {
            return root;
        }
        if (root!=null){
            TreeNode lNode=lowestCommonAncestor(root.left,p,q);
            TreeNode rNode=lowestCommonAncestor(root.right,p,q);
            if (lNode!=null&&rNode!=null) {
                return root;
            } else if(lNode==null) {
                //两个都在右子树
                return rNode;
            }
            else {
                //两个都在左子树里面
                return lNode;
            }
        }
        return null;
    }


    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestorHash(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
