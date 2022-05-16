package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/5/16 15:05
 */
public class Successor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null, cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre == p){
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null, cur = root;
        while (cur != null){
            if (cur.val > p.val){
                res = cur;
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return res;
    }
}
