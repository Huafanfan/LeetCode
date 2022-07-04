package neetcode.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/7/4 11:37
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0){
                return cur.val;
            }
            cur = cur.right;
        }
    }
}
