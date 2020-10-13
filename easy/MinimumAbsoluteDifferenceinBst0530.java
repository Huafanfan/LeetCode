package easy;

import medium.BinaryTreeInorderTraversal0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/10/13 09:20
 */
public class MinimumAbsoluteDifferenceinBst0530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        List< Integer > res = new ArrayList< >();
        Stack<TreeNode> stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (res.size() != 0){
                result = Math.min(result,Math.abs(res.get(res.size()-1)-curr.val));
            }
            res.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    int pre;
    int ans;

    public int getMinimumDifference2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
