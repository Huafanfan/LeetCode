package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/6 11:55
 */
public class BinaryTreeInorderTraversal0094 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    /**
     * 递归的方式
     * @param root
     * @return
     */
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList< >();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List< Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    /**
     * 使用栈
     * @param root
     * @return
     */
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List < Integer > inorderTraversal3(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                // move to next right node
                curr = curr.right;
            } else { // has a left subtree
                pre = curr.left;
                // find rightmost
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}
