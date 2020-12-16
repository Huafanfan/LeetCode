package lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/16 16:15
 */
public class Lcof28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 16.52%
     * 67.03%
     * @param root
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean recur(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null || A.val != B.val){
            return false;
        }
        return recur(A.left, B.right) && recur(A.right, B.left);
    }
}
