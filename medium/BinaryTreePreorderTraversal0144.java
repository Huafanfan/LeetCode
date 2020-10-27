package medium;

import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/10 11:10
 */
public class BinaryTreePreorderTraversal0144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        //Stack比Deque慢
        //Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.addLast(root);
        while (!treeNodes.isEmpty()){
            TreeNode tmp = treeNodes.pollLast();
            result.add(tmp.val);
            if (tmp.right!=null){
                treeNodes.addLast(tmp.right);
            }
            if (tmp.left!=null){
                treeNodes.addLast(tmp.left);
            }
        }
        return result;
    }

    /**
     * Morris 遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null) {
            pre = curr.left;
            if (pre != null) {
                while ((pre.right != null) && (pre.right != curr)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    res.add(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                    continue;
                }
                else{
                    pre.right = null;
                }
            }
            else {
                res.add(curr.val);
            }
            curr = curr.right;
        }
        return res;
    }
}
