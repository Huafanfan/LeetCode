package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/19 09:38
 */
public class SumofLeftLeaves404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumOfLeftLeavesBFS(TreeNode root) {
        int result = 0;
        if (root == null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i=0; i<queue.size(); i++){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                    if (node.left.left == null && node.left.right == null){
                        result += node.left.val;
                    }
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
    public int sumOfLeftLeavesDFS(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            l = root.left.val;
        }
        return l + sumOfLeftLeavesDFS(root.left) + sumOfLeftLeavesDFS(root.right);
    }
}
