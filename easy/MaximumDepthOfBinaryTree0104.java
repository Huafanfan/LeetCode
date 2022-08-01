package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/4/30 00:58
 */
public class MaximumDepthOfBinaryTree0104 {

    /**
     * 递归
     * 时间复杂度：我们每个结点只访问一次，因此时间复杂度为O(N)，
     * 其中 N是结点的数量。
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，
     * 递归将会被调用 N次（树的高度），因此保持调用栈的存储将是 O(N)。
     * 但在最好的情况下（树是完全平衡的），树的高度将是 log(N)。因此，在这种情况下的空间复杂度将是O(log(N))。
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left==null&&root.right==null){
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 迭代
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)。
     */
    public int maxDepthIterate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // bfs
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
