package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/8/19 17:18
 */
public class KthSmallestElementinaBst0230 {
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
    int n;
    int res;
    public void inorder(TreeNode root, int k){
        //剪枝
        if(root == null || n > k) {
            return;
        }
        inorder(root.left, k);
        n++;
        if(n == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public int kthSmallestIteration(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
